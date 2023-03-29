package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape{
    private String name;
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.sideLength, sideLength) == 0 && Objects.equals(name, square.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sideLength);
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return sideLength * sideLength;
    }
}
