package com.example.crudgame.controller;

import com.example.crudgame.model.Hero;
import com.example.crudgame.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class crudGameController {

    @Autowired
    private final HeroService heroService;

    public crudGameController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping("/new/{name}")
    public void createHero(@PathVariable("name") String name) {
        heroService.create(name);
    }

    @GetMapping("/getAll")
    public List<Hero> getAll() {
        return  heroService.getAll();
    }

    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable("id") int id) {
        return heroService.getHero(id);
    }

    @PutMapping("/upgreatAttack/{id}")
    public String upgreatAttack(@PathVariable("id") int id) {
        return heroService.upgreatAttack(id);
    }
    @PutMapping("/upgreatDefence/{id}")
    public String upgreatDefence(@PathVariable("id") int id) {
        return heroService.upgreatDefence(id);
    }






}
