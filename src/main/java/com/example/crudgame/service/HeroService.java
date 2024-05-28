package com.example.crudgame.service;

import com.example.crudgame.model.Hero;
import com.example.crudgame.repository.HeroRepository;
import com.example.crudgame.util.HeroNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Сервис для управления действиями с героями в игре.
 */
@Service
@Transactional(readOnly = true)
public class HeroService {

    private System.Logger logger =
            System.getLogger(HeroService.class.getName());

    private final HeroRepository repository;
    @Autowired
    public HeroService(HeroRepository repository) {
        this.repository = repository;
    }

    /**
     * Создает нового героя с указанным именем.
     * @param name Имя героя.
     */
    @Transactional
    public void create(String name) {
        Hero hero = new Hero();
        hero.setName(name);
        repository.save(hero);
        logger.log(System.Logger.Level.INFO, "Created a new hero: " + hero.getName());
    }

    /**
     * Получает героя по его идентификатору.
     * @param id Идентификатор героя.
     * @return Найденный герой.
     */
    public Hero getHero(int id) {
        Optional<Hero> foundHero = repository.findById(id);
        return foundHero.orElseThrow();
    }

    /**
     * Получает список всех героев.
     * @return Список всех героев.
     */
    public List<Hero> getAll() {
        logger.log(System.Logger.Level.INFO, "Retrieved all heroes");
        return repository.findAll();
    }

    /**
     * Увеличивает атаку героя на 1.
     * @param id Идентификатор героя.
     * @return Строка с информацией об увеличении атаки.
     */
    @Transactional
    public String upgreatAttack(int id) {
        Hero hero = getHero(id);
        int points = hero.getPerksPoints();
        if (points > 0) {
            hero.setAttack(hero.getAttack() + 1);
            hero.setPerksPoints(points - 1);
            repository.save(hero);
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
    @Transactional
    public String upgreatDefence(int id) {
        Hero hero = getHero(id);
        int points = hero.getPerksPoints();
        if (points > 0) {
            hero.setDefence(hero.getDefence() + 1);
            hero.setPerksPoints(points - 1);
            repository.save(hero);
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
    @Transactional
    public Hero getFigth(int id) {
        Hero hero = getHero(id);
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
        repository.save(hero);
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

    @Transactional
    public void deleteHero(int id) {
        repository.deleteById(id);
    }
}
