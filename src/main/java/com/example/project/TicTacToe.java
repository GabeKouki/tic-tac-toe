package com.example.project;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    private final List<Field> fields = new ArrayList<>();

    public TicTacToe() {
        for (int i = 0; i < 9; i++) {
            fields.add(new Field());
        }
    }

    public List<Field> getEmptyFields() {
        return fields;
    }

    public String getPlayerX() {
        return "X";
    }

    public String getPlayerO() {
        return "O";
    }

    private String currentPlayer = "X";

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void takeField(int index) {
        if (fields.get(index).isEmpty()) {
            fields.get(index).setOwner(currentPlayer);

            if (checkRowWin()) {
                winner = currentPlayer;
            } else {
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            }
        } else {
            throw new IllegalArgumentException("Field already taken!");
        }
    }

    private String winner = null;

    public String getWinner() {
        return winner;
    }

    private boolean checkRowWin() {
        return (fieldsMatch(0, 1, 2) ||
                fieldsMatch(3, 4, 5) ||
                fieldsMatch(6, 7, 8));
    }

    private boolean fieldsMatch(int a, int b, int c) {
        String ownerA = fields.get(a).getOwner();
        return ownerA != null &&
                ownerA.equals(fields.get(b).getOwner()) &&
                ownerA.equals(fields.get(c).getOwner());
    }

    public boolean isGameOver() {
        return winner != null || fields.stream().allMatch(field -> !field.isEmpty());
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