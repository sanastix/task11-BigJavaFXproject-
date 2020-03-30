package com.stepanyan.paint.shapes;

import com.stepanyan.paint.Board;
import com.stepanyan.paint.DisplayDriverImplementation;

public class SquareShape extends BaseShape {

    public SquareShape(Board board, DisplayDriverImplementation displayDriver, double x, double y) {
        super(board, displayDriver, x, y);
    }

    @Override
    public void draw() {
        displayDriver.drawSquare(x, y, size, active);
    }

    @Override
    public Shape copy() {
        return new SquareShape(board, displayDriver, x, y);
    }
}
