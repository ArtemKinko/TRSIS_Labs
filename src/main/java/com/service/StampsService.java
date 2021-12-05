package com.service;

import com.model.Stamp;

import java.util.Optional;

public interface StampsService {
    Iterable<Stamp> listAll();
    void delete(Integer id);
    Stamp add(Stamp stamp);
    Optional<Stamp> find(Integer id);
}
