package com.example.crudgame.service;


import com.example.crudgame.model.Hero;
import org.springframework.stereotype.Service;

@Service
public class HeroService {


    public Hero getHero(int id) {
        Hero hero = new Hero();
        return hero;
    }
}
