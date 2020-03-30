package com.stepanyan.paint.shapes;

import com.stepanyan.paint.Board;
import com.stepanyan.paint.DisplayDriverImplementation;

public class TriangleShape extends BaseShape {

    public TriangleShape(Board board, DisplayDriverImplementation displayDriver, double x, double y) {
        super(board, displayDriver, x, y);
    }

    @Override
    public void draw() {
        displayDriver.drawTriangle(x, y, size, active);
    }

    @Override
    public Shape copy() {
        return new TriangleShape(board, displayDriver, x, y);
    }
}
