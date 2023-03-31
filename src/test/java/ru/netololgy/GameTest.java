package ru.netololgy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    @Test
    public void shouldRegisterPlayer(){
        Game game = new Game();
        Player player1 = new Player(1, "kok", 9);

        Player[] expected = {player1};
        Player[] actual = game.register(player1);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotRegisterPlayerTwice(){
        Game game = new Game();
        Player player1 = new Player(1, "kok", 9);
        game.register(player1);

        Player[] expected = {player1};
        Player[] actual = game.register(player1);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "kok", 5);
        Player player2 = new Player(2, "mom", 8);
        Player player3 = new Player(3, "sos", 12);
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assert(player1 == game.findByName("kok"));
        assert(player2 == game.findByName("mom"));
    }
    @Test
    public void shouldNotFindPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "kok", 5);
        Player player2 = new Player(2, "mom", 8);
        Player player3 = new Player(3, "sos", 12);
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assert(null == game.findByName("lol"));
        assert(null == game.findByName("tot"));
    }
    @Test
    public void shouldThrowNotRegisteredException() {
        Game game = new Game();
        Player player1 = new Player(1, "kok", 5);
        Player player2 = new Player(2, "mom", 8);
        Player player3 = new Player(3, "sos", 12);
        game.register(player1);
        game.register(player2);
        game.register(player3);


        Assertions.assertThrows(NotRegisteredException.class,  () -> {
            game.round("kok", "lol");
        });
        Assertions.assertThrows(NotRegisteredException.class, ()->{
            game.round("don","kok");
        });

    }
    @Test
    public void shouldGoRound() {
        Game game = new Game();
        Player player1 = new Player(1, "kok", 5);
        Player player2 = new Player(2, "mom", 8);
        Player player3 = new Player(3, "sos", 12);
        Player player4 = new Player(4, "don", 8);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        assert(game.round("kok", "mom") == 2);
        assert(game.round("sos", "mom") == 1);
        assert(game.round("mom", "don") == 0);

    }
}
