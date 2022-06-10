package com.codemon;

public class FireMonster extends Monster {
  FireMonster(String name, int health, int attack) {
    super(name, health, attack);
  }

  @Override
  public void attack(Monster target) {
    this.takeDamage(target.get_attack());
    target.takeElementalAttack("burn", 3, this.get_attack() / 2);
  }

}
