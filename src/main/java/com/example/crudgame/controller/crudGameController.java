package com.example.crudgame.controller;

import com.example.crudgame.model.Hero;
import com.example.crudgame.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class crudGameController {

    @Autowired
    private final HeroService heroService;

    public crudGameController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable("id") int id) {
        return heroService.getHero(id);
    }
}
