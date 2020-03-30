package com.stepanyan.paint;

import com.stepanyan.paint.shapes.CompoundShape;
import com.stepanyan.paint.shapes.Shape;
import java.util.ArrayList;
import java.util.List;

public class Board {

    public enum Direction {UP, RIGHT, DOWN, LEFT}

    private DisplayDriverImplementation driver;
    private List<Shape> shapes = new ArrayList<>();
    private int index;

    public Board(DisplayDriverImplementation driver) {
        this.driver = driver;
        add(Shape.Type.CIRCLE);
    }

    public void move(Direction direction) {
        giveActiveShape().move(direction);
        drawShapes();
    }

    public void add(Shape.Type type) {
        shapes.add(ShapeCreator.createNewShape(type, this, driver, 0, 0));
        index = shapes.size() - 1;
        drawShapes();
    }

    public void decrease() {
        giveActiveShape().decrease();
        drawShapes();
    }

    public void increase() {
        giveActiveShape().increase();
        drawShapes();
    }

    public void remove() {
        if (shapes.size() == 0) {
            return;
        }
        shapes.remove(index);
        previousShape();
        drawShapes();
    }

    public void previousShape() {
        index--;
        if (index < 0) {
            index = shapes.size() - 1;
        }
        drawShapes();
    }

    public void nextShape() {
        index++;
        if (index >= shapes.size()) {
            index = 0;
        }
        drawShapes();
    }

    public void aggregateShapes(boolean done) {
        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            if (true) {
                Shape aggregated = new CompoundShape(shape.copy(), giveActiveShape().copy());
                if (done) {
                    Shape remove1 = shapes.get(i);
                    Shape remove2 = shapes.get(index);
                    shapes.remove(remove1);
                    shapes.remove(remove2);
                }
                shapes.add(aggregated);
                index = shapes.size() - 1;
                drawShapes();
                break;
            }
        }
    }

    public void copySmth() {
        Shape copiedShape = giveActiveShape().copy();
        shapes.add(copiedShape);
        copiedShape.activatedShape(true);
        index = shapes.size() - 1;
        drawShapes();
    }

    private void drawShapes() {
        driver.clearTheScreen();
            for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            if (i == index) {
                shape.activatedShape(true);
            } else {
                shape.activatedShape(false);
            }
            shape.draw();
        }
    }

    private Shape giveActiveShape() {
        return shapes.get(index);
    }

}
