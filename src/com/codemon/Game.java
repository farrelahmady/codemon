package com.codemon;

import java.util.*;

public class Game {
  Player[] players = new Player[2];

  Game(ArrayList<Player> players) {
    for (int i = 0; i < players.size(); i++) {
      this.players[i] = players.get(i);
    }
  }

  void start() {
    System.out.println("=====CodeMon=====\n");
    for (Player player : players) {
      player.show();
    }
  }

}
