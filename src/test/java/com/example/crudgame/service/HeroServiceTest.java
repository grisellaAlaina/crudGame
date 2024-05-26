package com.example.crudgame.service;

import com.example.crudgame.model.Hero;
import com.example.crudgame.repository.HeroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HeroServiceTest {
    private static final int ID = 0;

    @Mock
    private HeroRepository heroRepository;

    @InjectMocks
    private HeroService service;

    @Test
    void create() {
        final Hero hero = new Hero(0, "Bob");

        service.create("Bob");

        verify(heroRepository).addHero(hero);
    }

    @Test
    void getHero() {
        final Hero hero = mock(Hero.class);
        when(heroRepository.getById(ID)).thenReturn(hero);

        final Hero actualHero = service.getHero(ID);

        assertNotNull(actualHero);
        assertEquals(hero, actualHero);
    }

    @Test
    void getAll() {
        final List<Hero> heroList = mock(ArrayList.class);
        when(heroRepository.getAll()).thenReturn(heroList);

        final List<Hero> currentList = service.getAll();

        assertNotNull(currentList);
        assertEquals(heroList, currentList);
    }

    @Test
    void upgreatAttack() {
        final Hero hero = new Hero(0, "Bob");
        hero.setPerksPoints(1);
        when(heroRepository.getById(ID)).thenReturn(hero);

        final String acturalStr = service.upgreatAttack(ID);

        assertEquals(acturalStr, "Attack upgreated");
    }

    @Test
    void upgreatDefence() {
        final Hero hero = new Hero(0, "Bob");
        when(heroRepository.getById(ID)).thenReturn(hero);

        final String acturalStr = service.upgreatAttack(ID);

        assertEquals(acturalStr, "Not enough experience");
    }

    @Test
    void getFigth() {
        final Hero hero = new Hero(0, "Bob");
        hero.setAttack(99);
        when(heroRepository.getById(ID)).thenReturn(hero);

        Hero currentHero = service.getFigth(ID);

        assertEquals(hero, currentHero);
    }
}