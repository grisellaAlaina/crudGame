package com.example.crudgame.repository;

import com.example.crudgame.model.Hero;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class HeroRepositoryTest {
    private HeroRepository heroRepository = Mockito.mock(HeroRepository.class);

    @Test
    void testFindById() {
        Hero testHero = new Hero();
        testHero.setId(2);
        testHero.setName("Test Hero");
        Mockito.when(heroRepository.findById(2)).thenReturn(Optional.of(testHero));

        Optional<Hero> result = heroRepository.findById(2);

        assertEquals(testHero, result.orElse(null));
    }

    @Test
    void testSave() {
        Hero testHero = new Hero();
        testHero.setName("Test Hero");
        Mockito.when(heroRepository.save(testHero)).thenReturn(testHero);

        Hero savedHero = heroRepository.save(testHero);

        assertEquals(testHero, savedHero);
    }
}