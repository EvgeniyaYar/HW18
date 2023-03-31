package ru.netololgy;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public Player[] register(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
        return players.toArray(new Player[0]);
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Игрок с именем" + playerName1 + "не зарегистрирован"
            );
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Игрок с именем" + playerName2 + "не зарегистрирован"
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
