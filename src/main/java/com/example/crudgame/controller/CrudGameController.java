package com.example.crudgame.controller;

import com.example.crudgame.model.Hero;
import com.example.crudgame.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для
 * управления действиями с героями в игре.
 */
@RestController
public class CrudGameController {

    @Autowired
    private final HeroService heroService;

    /**
     * Конструктор контроллера.
     *
     * @param heroService Сервис для работы с героями.
     */
    public CrudGameController(HeroService heroService) {
        this.heroService = heroService;
    }

    /**
     * Метод для создания нового героя по имени.
     *
     * @param name Имя нового героя.
     */
    @PostMapping("/new/{name}")
    public void createHero(@PathVariable("name") String name) {
        heroService.create(name);
    }

    /**
     * Метод для получения списка всех героев.
     *
     * @return Список всех героев.
     */
    @GetMapping("/getAll")
    public List<Hero> getAll() {
        return heroService.getAll();
    }

    /**
     * Метод для получения героя по идентификатору.
     *
     * @param id Идентификатор героя.
     * @return Герой с указанным идентификатором.
     */
    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable("id") int id) {
        return heroService.getHero(id);
    }

    /**
     * Метод для улучшения атаки героя.
     *
     * @param id Идентификатор героя.
     * @return Сообщение об улучшении атаки.
     */
    @PatchMapping("/upgreatAttack/{id}")
    public String upgreatAttack(@PathVariable("id") int id) {
        return heroService.upgreatAttack(id);
    }

    /**
     * Метод для улучшения защиты героя.
     *
     * @param id Идентификатор героя.
     * @return Сообщение об улучшении защиты.
     */
    @PatchMapping("/upgreatDefence/{id}")
    public String upgreatDefence(@PathVariable("id") int id) {
        return heroService.upgreatDefence(id);
    }

    /**
     * Метод для начала боя героя.
     *
     * @param id Идентификатор героя.
     * @return информация о герое.
     */
    @PatchMapping("/getFight/{id}")
    public Hero getFigth(@PathVariable("id") int id) {
        return heroService.getFigth(id);
    }

}