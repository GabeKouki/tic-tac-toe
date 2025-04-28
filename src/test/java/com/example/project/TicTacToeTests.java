package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicTacToeTests {
    @Test
    void gameStartsWithNineEmptyFields() {
        TicTacToe game = new TicTacToe();
        assertEquals(9, game.getEmptyFields().size(), "A new game should have 9 empty fields.");
    }

    @Test
    void twoPlayersExist() {
        TicTacToe game = new TicTacToe();
        assertEquals("X", game.getPlayerX());
        assertEquals("O", game.getPlayerO());
    }

    @Test
    void playersAlternateTurns() {
        TicTacToe game = new TicTacToe();
        assertEquals("X", game.getCurrentPlayer(), "X should start the game");

        game.takeField(0);
        assertEquals("O", game.getCurrentPlayer(), "O should go after X");

        game.takeField(1);
        assertEquals("X", game.getCurrentPlayer(), "X should go after O");
    }

    @Test
    void cannotTakeAlreadyTakenField() {
        TicTacToe game = new TicTacToe();
        game.takeField(0);

        assertThrows(IllegalArgumentException.class, () -> {
            game.takeField(0);
        }, "Should not be able to take a field that is already taken.");
    }

    @Test
    void gameEndsInTieWhenAllFieldsTaken() {
        TicTacToe game = new TicTacToe();

        for (int i = 0; i < 9; i++) {
            game.takeField(i);
        }

        assertEquals(true, game.isGameOver(), "Game should be over when all fields are taken.");
    }

    @Test
    void playerWinsByCompletingRow() {
        TicTacToe game = new TicTacToe();

        game.takeField(0);
        game.takeField(3);
        game.takeField(1);
        game.takeField(4);
        game.takeField(2);

        assertEquals(true, game.isGameOver(), "Game should be over when a player completes a row.");
        assertEquals("X", game.getWinner(), "Player X should be the winner.");
    }

    @Test
void playerWinsByCompletingColumn() {
    TicTacToe game = new TicTacToe();

    game.takeField(0); 
    game.takeField(1); 
    game.takeField(3); 
    game.takeField(2); 
    game.takeField(6);

    assertEquals(true, game.isGameOver(), "Game should be over when a player completes a column.");
    assertEquals("X", game.getWinner(), "Player X should be the winner.");
}
}
