package com.pokemon.demo.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.opencsv.bean.CsvBindByName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Pokemon {
    @Id
    @CsvBindByName(column = "#")
    @Column(name = "id", nullable = false)
    private Long id;


    @CsvBindByName(column = "Name")
    @Column
    private String name;

    @CsvBindByName(column = "type 1")
    @Column
    private String type1;

    @CsvBindByName(column = "type 2")
    @Column
    private String type2;

    @CsvBindByName(column = "Total")
    @Column
    private int total;

    @CsvBindByName(column = "HP")
    @Column
    private int HP;

    @CsvBindByName(column = "Attack")
    @Column
    private int attack;

    @CsvBindByName(column = "Defense")
    @Column
    private int defense;

    @CsvBindByName(column = "Sp. Atk")
    @Column
    private int spAtk;

    @CsvBindByName(column = "Sp. Def")
    @Column
    private int spDef;

    @CsvBindByName(column = "Speed")
    @Column
    private int speed;

    @CsvBindByName(column = "Generation")
    @Column
    private int generation;

    @CsvBindByName(column = "Legendary")
    @Column
    private boolean legendary;

    public Pokemon() {
    }

    public Pokemon(long id, String title, String description) {
    }

    public Long getId() {
        return id;
    }

    @JsonSetter("#")
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @JsonSetter("Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    @JsonSetter("Type 1")
    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    @JsonSetter("Type 2")
    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getTotal() {
        return total;
    }

    @JsonSetter("Total")
    public void setTotal(int total) {
        this.total = total;
    }

    public int getHP() {
        return HP;
    }

    @JsonSetter("HP")
    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return attack;
    }

    @JsonSetter("Attack")
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    @JsonSetter("Defense")
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpAtk() {
        return spAtk;
    }

    @JsonSetter("Sp. Atk")
    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    @JsonSetter("Sp. Def")
    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public int getSpeed() {
        return speed;
    }

    @JsonSetter("Speed")
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGeneration() {
        return generation;
    }

    @JsonSetter("Generation")
    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public boolean isLegendary() {
        return legendary;
    }

    @JsonSetter("Legendary")
    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }
}
