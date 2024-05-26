package com.example.crudgame.repository;

import com.example.crudgame.model.Hero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HeroRepository {
    private final List<Hero> heroList = new ArrayList<>();

    public void addHero(Hero hero) {
        heroList.add(hero);
    }

    public Hero getById(int id) {
        return heroList.get(id);
    }


    public List<Hero> getAll() {
        return heroList;
    }

    public void updateHero(Hero hero) {
        heroList.set(hero.getId(), hero);
    }
}
