package com.service;

import com.model.UserDB;

import java.util.Optional;

public interface UserDBService {
    Optional<UserDB> find(String login);
}
