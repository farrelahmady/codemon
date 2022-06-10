package com.codemon;

import java.util.ArrayList;

public class Player {
  private String name;
  private ArrayList<Monster> cards = new ArrayList<Monster>();
  private ArrayList<String> cardNames = new ArrayList<String>();

  public Player(String name) {
    this.name = name;

  }

  public void add_card(Monster card) {
    this.cards.add(card);
    this.cardNames.add(card.get_name());
  }

  public Monster get_card(int index) {
    return cards.get(index);
  }

  public ArrayList<String> get_card_names() {
    return this.cardNames;
  }

  public String get_name() {
    return this.name;
  }

  public void show() {
    System.out.println("\n=====" + name + "=====");
    for (int i = 0; i < cards.size(); i++) {
      cards.get(i).show();
    }
  }

  public void play_turn(int own_card, int enemy_card, Player enemy) {
    System.out.println("\n=====" + name + "'s turn=====");
    System.out.println(name + "'s " + cards.get(own_card).get_name() + " attacks " + enemy.get_name() + "'s "
        + enemy.get_card(enemy_card).get_name() + " for " + cards.get(own_card).get_attack() + " damage!");
    cards.get(own_card).attack(enemy.get_card(enemy_card));
  }
}
