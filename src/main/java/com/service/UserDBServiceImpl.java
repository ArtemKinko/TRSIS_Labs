package com.service;

import com.model.UserDB;
import com.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDBServiceImpl implements UserDBService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserDB> find(String login) {
        return userRepository.findById(login);
    }
}
