package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StampsController {

    @RequestMapping(value = "/stamps", method = RequestMethod.GET)
    public ModelAndView see_all() {
        ModelAndView mav = new ModelAndView("stamps");
        return mav;
    }
}
