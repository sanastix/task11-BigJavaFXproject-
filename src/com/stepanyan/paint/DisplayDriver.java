package com.stepanyan.paint;

public interface DisplayDriver {

//    double getWidth();
//    double getHeight();
    void drawCircle(double x, double y, double diameter, boolean filled);
    void drawSquare(double x, double y, double size, boolean filled);
    void drawTriangle(double x, double y, double side, boolean filled);
    //void drawCompound();

}
