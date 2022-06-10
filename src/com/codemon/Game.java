package com.codemon;

import java.util.*;
import com.helper.*;

public class Game {
  ArrayList<Player> players = new ArrayList<Player>();
  static int turn = 1;
  Scanner input = new Scanner(System.in);

  Game(ArrayList<Player> players) {
    for (int i = 0; i < players.size(); i++) {
      this.players.add(players.get(i));
    }
  }

  void start() {

    System.out.println("=====GAME START=====");
    for (Player player : players) {
      player.show();
    }

    while (players.get(0).get_card().size() > 0 && players.get(1).get_card().size() > 0) {
      turn();
    }

  }

  void turn() {
    int index = RandomNum.getRandomNumber(0, players.size() - 1);
    int cardChosen;
    int targetChosen;

    System.out.println("\n=====" + players.get(index).get_name() + "'s turn=====");

    if (index == 0) {
      Boolean done = false;
      while (!done) {
        try {
          System.out.print("Choose Monster to Attack! ");
          cardChosen = input.nextInt() - 1;
          System.out.print("Choose Target! ");
          targetChosen = input.nextInt() - 1;
          players.get(0).play_turn(cardChosen, targetChosen, players.get(1));
          done = true;
        } catch (Exception e) {
          System.out.println("\nNeither you nor your opponent have that card!\n");
        }
      }

    } else {
      cardChosen = 0;
      targetChosen = 0;
      players.get(1).play_turn(cardChosen, targetChosen, players.get(0));
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }

    for (Player player : players) {
      player.show();
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }

    System.out.println("\n=========END TURN=========\n");

  }

}
