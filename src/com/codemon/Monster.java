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
    String text = "Name: " + name;
    text += this.status != null ? "[BURNT]" : "";
    text += "\tHealth: " + health + "\tAttack: " + attack;
    System.out.println(text);
  }

  public String get_name() {
    return name;
  }

  public int get_health() {
    return health;
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

  void takeElementalAttack(String status, int turn_remaining, int over_time_damage) {
    this.status = status;
    this.turn_remaining = turn_remaining;
    this.over_time_damage = over_time_damage;
  }

  void applyElementalEffect() {
    if (status == "burn") {
      takeDamage(over_time_damage);
      turn_remaining--;
      if (turn_remaining == 0) {
        status = "";
      }
    }
  }

}
