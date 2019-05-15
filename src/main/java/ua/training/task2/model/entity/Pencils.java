package ua.training.task2.model.entity;

import java.util.Random;

public class Pencils implements Toy {
    int countInPack;

    public Pencils() {
        countInPack =  (int)(Math.random() * (31-10) ) + 10;
    }

    @Override
    public String getName() {
        return "Pencils";
    }

    @Override
    public String getUaName() {
        return "Олівці";
    }


    @Override
    public String info() {
        return "{pencils in the pack = " + countInPack  + '}';
    }

    @Override
    public String infoUa() {
        return "{олівців у коробці = " + countInPack  + '}';
    }
}
