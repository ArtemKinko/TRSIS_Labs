package com.config;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/stamps").hasAnyRole("USER", "ADMIN")
                .antMatchers("/stamps/**").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login")
                .usernameParameter("name")
                .passwordParameter("pass")
                .defaultSuccessUrl("/stamps")
                .permitAll().and()
                .logout().permitAll().logoutSuccessUrl("/login?logout");
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("$2a$12$/YTkZNO0510.kYeSFqijVeOaaBTxjNaHZdAuo6Cu/H6fhgPufajbW")
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password("$2a$12$/mTmh.s4d1CmY5p1zjK50OZN25XklWkh738YXTlkbYDWTcrxg3SNe")
                .roles("USER");
    }

    @Bean
    public HttpFirewall allowSemi() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowSemicolon(true);
        return firewall;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.httpFirewall(allowSemi());
    }

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bcryptPasswordEncoder());
    }
}
