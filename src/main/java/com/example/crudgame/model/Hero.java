package com.example.crudgame.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

/**
 * Модель героя игры.
 */

@Entity
@Table(name = "tbl_hero")
public class Hero {

    public Hero() {
    }

    public Hero(String name, int totalFights, int level, int experience, int perksPoints, int attack, int defence) {
        this.name = name;
        this.totalFights = totalFights;
        this.level = level;
        this.experience = experience;
        this.perksPoints = perksPoints;
        this.attack = attack;
        this.defence = defence;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @Column(name = "total_fights")
    private int totalFights = 0;

    @Column(name = "level")
    private int level = 0;

    @Column(name = "experience")
    private int experience = 50;

    @Column(name = "perks_points")
    private int perksPoints = 0;

    @Column(name = "attack")
    private int attack = 0;

    @Column(name = "defence")
    private int defence = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getTotalFights() {
        return totalFights;
    }

    public void setTotalFights(int totalFights) {
        this.totalFights = totalFights;
    }

    public int getPerksPoints() {
        return perksPoints;
    }

    public void setPerksPoints(int perksPoints) {
        this.perksPoints = perksPoints;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return id == hero.id && totalFights == hero.totalFights && level == hero.level && experience == hero.experience && attack == hero.attack && defence == hero.defence && Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, totalFights, level, experience, attack, defence);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalFights=" + totalFights +
                ", level=" + level +
                ", experience=" + experience +
                ", perksPoints=" + perksPoints +
                ", attack=" + attack +
                ", defence=" + defence +
                '}';
    }
}
