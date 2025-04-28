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
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        } else {
            throw new IllegalArgumentException("Field already taken!");
        }
    }

    public boolean isGameOver() {
        return fields.stream().allMatch(field -> !field.isEmpty());
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
}
