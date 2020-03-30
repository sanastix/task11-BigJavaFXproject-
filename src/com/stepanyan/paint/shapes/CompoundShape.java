package com.stepanyan.paint.shapes;

import com.stepanyan.paint.Board;

import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements Shape {

    private List<Shape> shapes = new ArrayList<Shape>();

    public CompoundShape() {
    }

    private CompoundShape(List<Shape> shapes) {
        setList(shapes);
    }

    public CompoundShape(Shape shapeOne, Shape shapeTwo) {
        addShape(shapeOne);
        addShape(shapeTwo);
    }

    @Override
    public void draw() {
        for (Shape shape: shapes) {
            shape.draw();
        }
    }

    @Override
    public void move(Board.Direction direction) {
        for (Shape shape: shapes) {
            shape.move(direction);
        }
    }

    @Override
    public void decrease() {
        for (Shape shape: shapes) {
            shape.decrease();
        }
    }

    @Override
    public void increase() {
        for (Shape shape: shapes) {
            shape.increase();
        }
    }

    @Override
    public void activatedShape(boolean active) {
        for (Shape shape: shapes) {
            shape.activatedShape(active);
        }
    }

    @Override
    public Shape copy() {
        List<Shape> shapesCopy = new ArrayList<Shape>();
        for (Shape shape: shapes) {
            shapesCopy.add(shape.copy());
        }
        return new CompoundShape(shapesCopy);
    }

    private void addShape(Shape shape) {
        if (shape instanceof CompoundShape) {
            CompoundShape compoundShape = (CompoundShape) shape;
            shapes.addAll(compoundShape.getList());
        } else {
            shapes.add(shape);
        }
    }

    private void setList(List<Shape> shapes) {
        this.shapes.clear();
        for (Shape shape : shapes) {
            addShape(shape);
        }
    }

    private List<Shape> getList() {
        return shapes;
    }

}
