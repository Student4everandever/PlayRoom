package ua.training.task2.model.entity;

import java.util.Random;

public class Puzzle implements Toy {
    private int numberOfPieces;
    private int [] values = {20, 30, 50, 100, 150, 200, 250, 300, 500};

    public Puzzle() {
        numberOfPieces = new Random().nextInt(values.length);
    }

    @Override
    public String getName() {
        return "Puzzle";
    }

    @Override
    public String getUaName() {
        return "Пазли";
    }

    @Override
    public String info() {
        return "{pieces = " + values[numberOfPieces] + '}';
    }

    @Override
    public String infoUa() {
        return "{кількість елементів = " + values[numberOfPieces] + '}';
    }
}
