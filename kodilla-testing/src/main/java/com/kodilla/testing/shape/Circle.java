package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements Shape{
    private String name;
    private double diameter;

    public Circle(String name, double diameter) {
        this.name = name;
        this.diameter = diameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.diameter, diameter) == 0 && Objects.equals(name, circle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, diameter);
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        double pi = 3.14;
        return pi*diameter*diameter;
    }
}
