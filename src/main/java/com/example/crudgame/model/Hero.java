package com.example.crudgame.model;


import java.util.Objects;

public class Hero {
    public Hero(int id, String name) {
        this.id = id;
        this.name = name;
    }
    private int id;
    private String name;
    private int totalFights = 0;
    private int level = 0;
    private int experience = 0;
    private int perksPoints = 0;
    private int attack = 0;
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
}
