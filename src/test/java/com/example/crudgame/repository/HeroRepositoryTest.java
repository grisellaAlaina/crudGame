package com.example.crudgame.repository;

import com.example.crudgame.model.Hero;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroRepositoryTest {

    private HeroRepository repository;
    private Hero hero;

    HeroRepositoryTest() {
    }

    @BeforeEach
    void setup() {
        repository = new HeroRepository();
        hero = new Hero(0, "Bob");
    }


    @Test
    void addHero() {
        Hero currentHero = new Hero(0, "Bob");

        repository.addHero(currentHero);
        Hero testHero = repository.getById(0);

        assertNotNull(testHero);
        assertEquals(hero, testHero);
    }

    @Test
    void getById() {
        Hero currentHero = new Hero(0, "Bob");
        Hero currentHero2 = new Hero(1, "Bob");

        repository.addHero(currentHero);
        repository.addHero(currentHero2);
        Hero testHero = repository.getById(0);

        assertNotNull(testHero);
        assertEquals(hero, testHero);
    }

    @Test
    void getAll() {
        Hero currentHero = new Hero(0, "Bob");
        Hero currentHero2 = new Hero(1, "Bob");
        List<Hero> heroList = new ArrayList<>();
        heroList.add(currentHero);
        heroList.add(currentHero2);

        repository.addHero(currentHero);
        repository.addHero(currentHero2);
        List<Hero> currentList = repository.getAll();

        assertNotNull(currentList);
        assertEquals(heroList, currentList);

    }

    @Test
    void updateHero() {
        Hero currentHero = new Hero(0, "Bob");

        repository.addHero(currentHero);
        repository.updateHero(hero);
        Hero testHero = repository.getById(0);

        assertNotNull(testHero);
        assertEquals(hero, testHero);
    }

}
