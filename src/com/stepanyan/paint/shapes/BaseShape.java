package com.stepanyan.paint.shapes;

import com.stepanyan.paint.Board;
import com.stepanyan.paint.DisplayDriverImplementation;

public abstract class BaseShape implements Shape {

    protected double size = 50;
    protected double MIN_SIZE = 10;
    protected double MAX_SIZE = 90;
    protected Board board;
    protected DisplayDriverImplementation displayDriver;
    protected double x;
    protected double y;
    protected boolean active;

    public BaseShape(Board board, DisplayDriverImplementation displayDriver, double x, double y) {
        this.board = board;
        this.displayDriver = displayDriver;
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(Board.Direction direction) {
        switch (direction) {
            case UP:
                y -= 10;
                break;
            case RIGHT:
                x += 10;
                break;
            case DOWN:
                y += 10;
                break;
            case LEFT:
                x -= 10;
                break;
        }
    }

    @Override
    public void increase() {
        size += 5;
        if (size > MAX_SIZE) {
            size = MAX_SIZE;
        }
    }

    @Override
    public void decrease() {
        size -= 5;
        if (size < MIN_SIZE) {
            size = MIN_SIZE;
        }
    }

    @Override
    public void activatedShape(boolean active) {
        this.active = active;
    }

}
