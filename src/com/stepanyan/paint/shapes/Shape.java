package com.stepanyan.paint.shapes;

import com.stepanyan.paint.Board;

public interface Shape {

    enum Type {CIRCLE,SQUARE,TRIANGLE,COMPOUND}
    void draw();
    void move(Board.Direction direction);
    void decrease();
    void increase();
    void activatedShape(boolean active);
    Shape copy();

}
