package com.example.crudgame.repository;

import com.example.crudgame.model.Hero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HeroRepository {
    private final List<Hero> heroList = new ArrayList<>();

    /**
     * Добавляет нового героя в хранилище.
     * @param hero Добавляемый герой.
     */
    public void addHero(Hero hero) {
        heroList.add(hero);
    }

    /**
     * Получает героя по его идентификатору.
     * @param id Идентификатор героя.
     * @return Найденный герой.
     */
    public Hero getById(int id) {
        return heroList.get(id);
    }

    /**
     * Получает список всех героев.
     * @return Список всех героев.
     */
    public List<Hero> getAll() {
        return heroList;
    }

    /**
     * Обновляет информацию о герое.
     * @param hero Обновляемый герой.
     */
    public void updateHero(Hero hero) {
        heroList.set(hero.getId(), hero);
    }
}
