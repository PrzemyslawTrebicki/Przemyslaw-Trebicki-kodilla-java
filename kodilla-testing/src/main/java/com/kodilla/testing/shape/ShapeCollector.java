package com.kodilla.testing.shape;

//import java.util.ArrayList;
//import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapeCollection = new ArrayList<>();

    public List<Shape> getShapeCollection(){
        return shapeCollection;
    }

    void addFigure(Shape shape) {
        shapeCollection.add(shape);
    }
    void removeFigure(Shape shape){
        shapeCollection.remove(shape);
    }
    Shape getFigure(int n){
        if(n < shapeCollection.size() && n >= 0){
            return shapeCollection.get(n);
        }else {
            return null;
        }
    }
    String showFigures(){
        String longName = "";
        for (Shape shape:shapeCollection) {
            longName = longName +" "+ shape.getShapeName();
        }
        return longName;
    }
}
