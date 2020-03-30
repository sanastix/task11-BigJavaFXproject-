package com.stepanyan.paint;

import com.stepanyan.paint.shapes.*;

public class ShapeCreator {

    public static Shape createNewShape(Shape.Type type, Board board, DisplayDriverImplementation displayDriver, double x, double y) {
        switch (type) {
            case CIRCLE:
                return new CircleShape(board, displayDriver, x, y);
            case SQUARE:
                return new SquareShape(board, displayDriver, x, y);
            case TRIANGLE:
                return new TriangleShape(board, displayDriver, x, y);
            case COMPOUND:
                return new CompoundShape();
            default:
                return null;
        }
    }

}
