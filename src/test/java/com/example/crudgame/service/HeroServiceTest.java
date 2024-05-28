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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HeroServiceTest {
    private static final int ID = 1;

    @Mock
    private HeroRepository heroRepository;

    @InjectMocks
    private HeroService service;

    @Test
    void getHero() {
        final Hero hero = mock(Hero.class);
        when(heroRepository.findById(ID)).thenReturn(Optional.ofNullable(hero));

        final Hero actualHero = service.getHero(ID);

        assertNotNull(actualHero);
        assertEquals(hero, actualHero);
    }

    @Test
    void getAll() {
        final List<Hero> heroList = mock(ArrayList.class);
        when(heroRepository.findAll()).thenReturn(heroList);

        final List<Hero> currentList = service.getAll();

        assertNotNull(currentList);
        assertEquals(heroList, currentList);
    }

    @Test
    void upgreatAttack() {
        final Hero hero = new Hero();
        hero.setPerksPoints(1);
        when(heroRepository.findById(ID)).thenReturn(Optional.ofNullable(hero));

        final String acturalStr = service.upgreatAttack(ID);

        assertEquals(acturalStr, "Attack upgreated");
    }

    @Test
    void upgreatDefence() {
        final Hero hero = new Hero();
        when(heroRepository.findById(ID)).thenReturn(Optional.ofNullable(hero));

        final String acturalStr = service.upgreatAttack(ID);

        assertEquals(acturalStr, "Not enough experience");
    }

    @Test
    void getFigth() {
        final Hero hero = new Hero();
        hero.setAttack(99);
        when(heroRepository.findById(ID)).thenReturn(Optional.ofNullable(hero));

        Hero currentHero = service.getFigth(ID);

        assertEquals(hero, currentHero);
    }
}