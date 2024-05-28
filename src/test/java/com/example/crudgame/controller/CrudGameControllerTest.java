package com.example.crudgame.controller;

import com.example.crudgame.model.Hero;
import com.example.crudgame.service.HeroService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

class CrudGameControllerTest {

    private final HeroService heroService = Mockito.mock(HeroService.class);
    private final CrudGameController controller = new CrudGameController(heroService);

    @Test
    void testCreateHero() {
        controller.createHero("TestHero");
        Mockito.verify(heroService).create("TestHero");
    }

    @Test
    void testGetAll() {
        List<Hero> heroes = new ArrayList<>();
        Mockito.when(heroService.getAll()).thenReturn(heroes);

        List<Hero> result = controller.getAll();

        Mockito.verify(heroService).getAll();
        assertEquals(heroes, result);
    }

    @Test
    void testGetHeroById() {
        Hero testHero = new Hero();
        testHero.setId(1);
        Mockito.when(heroService.getHero(anyInt())).thenReturn(testHero);

        Hero result = controller.getHeroById(1);

        Mockito.verify(heroService).getHero(1);
        assertEquals(testHero, result);
    }

    @Test
    void testUpgreatAttack() {
        Mockito.when(heroService.upgreatAttack(anyInt())).thenReturn("Attack upgraded");

        String result = controller.upgreatAttack(1);

        Mockito.verify(heroService).upgreatAttack(1);
        assertEquals("Attack upgraded", result);
    }

    @Test
    void testUpgreatDefence() {
        Mockito.when(heroService.upgreatDefence(anyInt())).thenReturn("Defence upgraded");

        String result = controller.upgreatDefence(1);

        Mockito.verify(heroService).upgreatDefence(1);
        assertEquals("Defence upgraded", result);
    }

    @Test
    void testGetFigth() {
        Hero testHero = new Hero();
        testHero.setId(1);
        Mockito.when(heroService.getFigth(anyInt())).thenReturn(testHero);

        Hero result = controller.getFigth(1);

        Mockito.verify(heroService).getFigth(1);
        assertEquals(testHero, result);
    }
}