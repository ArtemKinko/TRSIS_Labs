package com.service;

import com.model.Stamp;
import com.model.StampRepository;
import com.service.StampsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StampsServiceImpl implements StampsService {

    @Autowired
    private StampRepository stampRepository;

    @Override
    public Iterable<Stamp> listAll() {
        return stampRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        stampRepository.deleteById(id);
    }

    @Override
    public Stamp add(Stamp stamp) {
        return stampRepository.save(stamp);
    }

    @Override
    public Optional<Stamp> find(Integer id) {
        return stampRepository.findById(id);
    }
}
