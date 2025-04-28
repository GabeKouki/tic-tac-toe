package com.example.project;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";

    private final List<Field> fields = new ArrayList<>();
    private String currentPlayer = PLAYER_X;
    private String winner = null;

    public TicTacToe() {
        for (int i = 0; i < 9; i++) {
            fields.add(new Field());
        }
    }

    public List<Field> getEmptyFields() {
        return fields;
    }

    public String getPlayerX() {
        return PLAYER_X;
    }

    public String getPlayerO() {
        return PLAYER_O;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void takeField(int index) {
        if (fields.get(index).isEmpty()) {
            fields.get(index).setOwner(currentPlayer);

            if (checkWin()) {
                winner = currentPlayer;
            } else {
                currentPlayer = currentPlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        } else {
            throw new IllegalArgumentException("Field already taken!");
        }
    }

    public boolean isGameOver() {
        return winner != null || fields.stream().allMatch(field -> !field.isEmpty());
    }

    public String getWinner() {
        return winner;
    }

    private static final int[][] WINNING_COMBINATIONS = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
        {0, 4, 8}, {2, 4, 6}             // diagonals
    };
    
    private boolean checkWin() {
        for (int[] combo : WINNING_COMBINATIONS) {
            if (fieldsMatch(combo[0], combo[1], combo[2])) {
                return true;
            }
        }
        return false;
    }

    private boolean fieldsMatch(int a, int b, int c) {
        String ownerA = fields.get(a).getOwner();
        return ownerA != null &&
               ownerA.equals(fields.get(b).getOwner()) &&
               ownerA.equals(fields.get(c).getOwner());
    }
}

class Field {
    private String owner = null;

    public boolean isEmpty() {
        return owner == null;
    }

    public void setOwner(String player) {
        this.owner = player;
    }

    public String getOwner() {
        return owner;
    }
}