package ua.training.task2.model.entity;

import ua.training.task2.model.enums.Color;
import ua.training.task2.model.enums.ColorUa;
import ua.training.task2.model.enums.Size;
import ua.training.task2.model.enums.SizeUa;

import java.util.Random;

public class Doll implements Toy {
    private Size size;
    private SizeUa sizeUa;
    private Color color;
    private ColorUa colorUa;

    Doll() {
        size = Size.values()[new Random().nextInt(Size.values().length)];
        sizeUa = SizeUa.values()[new Random().nextInt(SizeUa.values().length)];
        color = Color.values()[new Random().nextInt(Color.values().length)];
        colorUa = ColorUa.values()[new Random().nextInt(ColorUa.values().length)];
    }

    @Override
    public String getName() {
        return "Doll";
    }

    @Override
    public String getUaName() {
        return "Лялька";
    }

    public Size getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String info() {
        return "{size = " + size + ", color = " + color + "}";
    }

    @Override
    public String infoUa() {
        return "{розмір = " + sizeUa + ", колір = " + colorUa + "}";
    }
}
