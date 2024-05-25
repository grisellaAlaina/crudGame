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

    public String upgreatAttack(int id) {
        Hero hero = repository.getById(id);
        if(hero.getLevel() > hero.getAttack() + hero.getDefence()) {
            hero.setAttack(hero.getAttack() + 1);
            repository.updateHero(hero);
            return "Attack upgreated";
        }
        return "Not enouth experience";
    }
    public String upgreatDefence(int id) {
        Hero hero = repository.getById(id);
        if(hero.getLevel() > hero.getAttack() + hero.getDefence()) {
            hero.setDefence(hero.getDefence() + 1);
            repository.updateHero(hero);
            return "Defence upgreated";
        }
        return "Not enough experience";
    }
}
