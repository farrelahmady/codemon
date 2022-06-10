package com.codemon;

public class Monster implements Cloneable {
  private String name;
  private int health;
  private int attack;
  private String status;
  private int turn_remaining;
  private int over_time_damage;

  Monster(String name, int health, int attack) {
    this.name = name;
    this.health = health;
    this.attack = attack;
  }

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  void show() {
    System.out.println("Name: " + name + "\t\tHealth: " + health + "\t\tAttack: " + attack);
  }

  public String get_name() {
    return name;
  }

  public int get_attack() {
    return attack;
  }

  void attack(Monster target) {
    this.takeDamage(target.attack);
    target.takeDamage(attack);
  }

  void takeDamage(int damage) {
    health -= damage;
  }
}
