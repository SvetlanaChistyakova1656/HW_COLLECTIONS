package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenSecondPlayerWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 10);
        Player player2 = new Player(2, "Player2", 20);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Player1", "Player2");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 20);
        Player player2 = new Player(2, "Player2", 10);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Player1", "Player2");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Game game = new Game();
        Player player2 = new Player(1, "Player2", 20);

        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player8", "Player2"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 10);

        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player1", "Player10"));
    }

    @Test
    public void testWhenPlayerNotExist() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player1", "Player10"));
    }

    @Test
    public void testRoundDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 10);
        Player player2 = new Player(2, "Player2", 10);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Player1", "Player2");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
}
