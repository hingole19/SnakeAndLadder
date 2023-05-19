package com.snakeandladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SnakeAndLadderApplicationTests {
	private Game game;
	private Player player;

    @BeforeEach
    public void setup() {
        game = new Game(1);
    }

    @Test
    public void testPlayTurn() {
        int initialPosition = player.getPosition();

        game.play();

        int newPosition = player.getPosition();
        Assertions.assertNotEquals(initialPosition, newPosition);
    }

    @Test
    public void testIsGameFinished() {
        // Test when the game is not finished
        player.setPosition(50);
        Assertions.assertFalse(game.isGameFinished());

        // Test when the game is finished
        player.setPosition(100);
        Assertions.assertTrue(game.isGameFinished());
    }

}
