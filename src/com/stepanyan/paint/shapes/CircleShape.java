package com.stepanyan.paint.shapes;

import com.stepanyan.paint.Board;
import com.stepanyan.paint.DisplayDriverImplementation;

public class CircleShape extends BaseShape {

    public CircleShape(Board board, DisplayDriverImplementation displayDriver, double x, double y) {
        super(board, displayDriver, x, y);
    }

    @Override
    public void draw() {
        displayDriver.drawCircle(x, y, size, active);
    }

    @Override
    public Shape copy() {
        return new CircleShape(board, displayDriver, x, y);
    }
}
