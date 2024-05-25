package com.example.crudgame.service;


import com.example.crudgame.model.Hero;
import com.example.crudgame.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    HeroRepository repository;

    public void create(String name) {
        repository.addHero(name);
    }


    public Hero getHero(int id) {
        return repository.getById(id);
    }

    public List<Hero> getAll() {
        return repository.getAll();
    }
}
