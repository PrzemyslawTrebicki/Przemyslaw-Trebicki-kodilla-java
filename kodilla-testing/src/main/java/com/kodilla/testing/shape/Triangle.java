package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape{
    private String name;
    private double baseLength;
    private double heightLength;

    public Triangle(double baseLength, double heightLength) {
        this.baseLength = baseLength;
        this.heightLength = heightLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.baseLength, baseLength) == 0 && Double.compare(triangle.heightLength, heightLength) == 0 && Objects.equals(name, triangle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, baseLength, heightLength);
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return 0.5*baseLength*heightLength;
    }
}
