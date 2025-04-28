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
}

class Field {
    private String owner = null;

    public boolean isEmpty() {
        return owner == null;
    }
}
