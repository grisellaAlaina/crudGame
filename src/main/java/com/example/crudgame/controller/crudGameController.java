package com.example.crudgame.controller;

import com.example.crudgame.model.Hero;
import com.example.crudgame.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class crudGameController {

    @Autowired
    private final HeroService heroService;

    public crudGameController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping("/new")
    public void createHero() {
        heroService.create();
    }

    @GetMapping("/getAll")
    public List<Hero> getAll() {
        return  heroService.getAll();
    }

    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable("id") int id) {
        return heroService.getHero(id);
    }
}
