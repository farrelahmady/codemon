package com.codemon;

import java.util.*;
import com.helper.*;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) throws CloneNotSupportedException {

    Scanner input = new Scanner(System.in);

    int inputNum;

    Monster phpkachu = new Monster("Phpkachu", 120, 50);
    Monster sqlrtle = new Monster("Sqlrtle", 180, 20);
    Monster cppmander = new Monster("cppmander", 100, 80);
    Monster bashtoise = new Monster("bashtoise", 120, 60);
    Monster torterraform = new Monster("torterraform", 200, 10);

    ArrayList<Monster> monstersList = new ArrayList<Monster>();
    monstersList.add(phpkachu);
    monstersList.add(sqlrtle);
    monstersList.add(cppmander);
    monstersList.add(bashtoise);
    monstersList.add(torterraform);

    System.out.print("=====Welcome to CodeMon!=====\nPlease enter your name: ");
    String name = input.nextLine();
    Player player1 = new Player(name);
    for (int i = 0; i < 2; i++) {
      int num;
      do {
        num = RandomNum.getRandomNumber(0, monstersList.size() - 1);
      } while (player1.get_card_names().contains(monstersList.get(num).get_name()));
      player1.add_card((Monster) monstersList.get(num).clone());
    }

    Player player2 = new Player("Computer");
    for (int i = 0; i < 2; i++) {
      int num;
      do {
        num = RandomNum.getRandomNumber(0, monstersList.size() - 1);
      } while (player2.get_card_names().contains(monstersList.get(num).get_name()));
      player2.add_card((Monster) monstersList.get(num).clone());
    }

    ArrayList<Player> playersList = new ArrayList<Player>();
    playersList.add(player1);
    playersList.add(player2);

    Game game = new Game(playersList);
    game.start();

  }

}