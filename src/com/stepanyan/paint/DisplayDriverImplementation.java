package com.stepanyan.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DisplayDriverImplementation implements DisplayDriver {

    private final GraphicsContext gc;

    public DisplayDriverImplementation(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void drawCircle(double x, double y, double diameter, boolean filled) {
        gc.setFill(Color.RED);
        gc.setStroke(Color.RED);
        gc.setLineWidth(3);
        if (filled) {
            gc.fillOval(x, y, diameter, diameter);
        } else {
            gc.strokeOval(x, y, diameter, diameter);
        }
    }

    @Override
    public void drawSquare(double x, double y, double size, boolean filled) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(3);
        if (filled) {
            gc.fillRect(x, y, size, size);
        } else {
            gc.strokeRect(x, y, size, size);
        }
    }

    @Override
    public void drawTriangle(double x, double y, double size, boolean filled) {
        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(3);
        if (filled) {
            gc.fillPolygon(new double[]{x, x + size / 2.0, x + size}, new double[]{y + size, y, y + size},3);
        } else {
            gc.strokePolygon(new double[]{x, x + size / 2.0, x + size}, new double[]{y + size, y, y + size},3);
        }
    }

    void clearTheScreen() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

}
