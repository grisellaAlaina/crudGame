package com.example.crudgame.service;

import com.example.crudgame.model.Hero;
import com.example.crudgame.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Сервис для управления действиями с героями в игре.
 */
@Service
public class HeroService {

    private System.Logger logger =
            System.getLogger(HeroService.class.getName());

    @Autowired
    HeroRepository repository;

    private static int idGen = 0;

    /**
     * Создает нового героя с указанным именем.
     * @param name Имя героя.
     */
    public void create(String name) {
        Hero hero = new Hero(idGen++, name);
        repository.addHero(hero);
        logger.log(System.Logger.Level.INFO, "Created a new hero: " + hero.getName());
    }

    /**
     * Получает героя по его идентификатору.
     * @param id Идентификатор героя.
     * @return Найденный герой.
     */
    public Hero getHero(int id) {
        Hero hero = repository.getById(id);
        logger.log(System.Logger.Level.INFO, "Retrieved hero by id: " + hero.getName());
        return hero;
    }

    /**
     * Получает список всех героев.
     * @return Список всех героев.
     */
    public List<Hero> getAll() {
        logger.log(System.Logger.Level.INFO, "Retrieved all heroes");
        return repository.getAll();
    }

    /**
     * Увеличивает атаку героя на 1.
     * @param id Идентификатор героя.
     * @return Строка с информацией об увеличении атаки.
     */
    public String upgreatAttack(int id) {
        Hero hero = repository.getById(id);
        int points = hero.getPerksPoints();
        if (points > 0) {
            hero.setAttack(hero.getAttack() + 1);
            hero.setPerksPoints(points - 1);
            repository.updateHero(hero);
            logger.log(System.Logger.Level.INFO,
                    "Upgraded attack for hero with id: " + id);
            return "Attack upgreated";
        }
        return "Not enough experience";
    }

    /**
     * Увеличивает защиту героя на 1.
     * @param id Идентификатор героя.
     * @return Строка с информацией об увеличении защиты.
     */
    public String upgreatDefence(int id) {
        Hero hero = repository.getById(id);
        int points = hero.getPerksPoints();
        if (points > 0) {
            hero.setDefence(hero.getDefence() + 1);
            hero.setPerksPoints(points - 1);
            repository.updateHero(hero);
            logger.log(System.Logger.Level.INFO,
                    "Upgraded defence for hero with id: " + id);
            return "Defence upgreated";
        }
        return "Not enough experience";
    }

    /**
     * Запускает сражение героя с другими героями.
     * @param id Идентификатор героя.
     * @return Результат сражения.
     */
    public Hero getFigth(int id) {
        Hero hero = repository.getById(id);
        for (int i = 0; i < 10; i++) {
            hero.setTotalFights(hero.getTotalFights() + 1);
            if (i * 2 - hero.getDefence() < hero.getAttack()) {
                hero = winResult(hero, i);
                logger.log(System.Logger.Level.INFO,
                        "Hero won the fight at round " + i);
                continue;
            } else if (i * 2 - hero.getDefence() == hero.getAttack()) {
                Random random = new Random();
                if (random.nextBoolean()) {
                    hero = winResult(hero, i);
                    logger.log(System.Logger.Level.INFO,
                            "Hero won the fight at round " + i);
                    continue;
                }
            }
            logger.log(System.Logger.Level.INFO, "Hero lost the fight at round " + i);
            break;
        }
        repository.updateHero(hero);
        return hero;
    }

    /**
     * Обрабатывает победу героя в сражении.
     * @return Герой после обновления параметров.
     */
    private Hero winResult(Hero hero, int i) {
        hero.setExperience(hero.getExperience() + (i + 1) * 10);
        if (hero.getExperience() > 100) {
            hero.setLevel(hero.getLevel() + 1);
            hero.setPerksPoints(hero.getPerksPoints() + 1);
            hero.setExperience(0);
        }
        if (i == 9) hero.setName("CHAMPION");
        return hero;
    }
}
