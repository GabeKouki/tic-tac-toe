package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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

        game.takeField(0); // X takes a move
        assertEquals("O", game.getCurrentPlayer(), "O should go after X");

        game.takeField(1); // O takes a move
        assertEquals("X", game.getCurrentPlayer(), "X should go after O");
    }
}
