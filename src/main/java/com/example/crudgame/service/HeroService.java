package com.example.crudgame.service;


import com.example.crudgame.model.Hero;
import com.example.crudgame.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

    public Hero getFigth(int id) {
        Hero hero = repository.getById(id);
        for(int i = 0; i < 10; i++) {
            hero.setTotalFights(hero.getTotalFights() + 1);
            if (i - hero.getDefence() > hero.getAttack()) {
                hero = winResult(hero, i);
                break;
            } else if (i - hero.getDefence() == hero.getAttack()) {
                Random random = new Random();
                if (random.nextBoolean()) {
                    hero = winResult(hero, i);
                    break;
                }
            }

        }
        repository.updateHero(hero);
        return hero;
    }

    public Hero winResult(Hero hero, int i) {
        hero.setExperience(hero.getExperience() + i * 13);
        if (hero.getExperience() > 100) {
            hero.setLevel(hero.getLevel() + 1);
            hero.setExperience(0);
        }
        if (i == 9) hero.setName("CHAMPION");
        return hero;
    }
}
