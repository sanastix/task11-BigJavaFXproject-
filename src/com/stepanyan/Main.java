package com.stepanyan;

import com.stepanyan.paint.Board;
import com.stepanyan.paint.shapes.Shape;
import com.stepanyan.paint.DisplayDriverImplementation;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    /*
    Написать программу с использованием JavaFx:
    + Можно добавить не менее 3 типов фигур
    + У выбранной фигуры можно менять размер и двигать ее
    + Фигуру можно удалить
    + Фигуры можно объеденять в группы (агрегация) и клонировать
    ? Реализовать сохранение/загрузку состояния в файл
    + В программе обязательно использовать интерфейсы и абстрактные классы.
    Дополнительные задания:
    - Сделать чтобы при движении фигуры не могли наехать друг на друга
    - Реализовать запоминание траектории и воспроизведение
     */

    private static final int BOARD_WIDTH = 1300;
    private static final int BOARD_HEIGHT = 1000;
    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("HomeTask11");
        final Canvas canvas = new Canvas();
        canvas.setHeight(BOARD_HEIGHT);
        canvas.setWidth(BOARD_WIDTH);
        final BorderPane group = new BorderPane(canvas);
        final Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        DisplayDriverImplementation displayDriver = new DisplayDriverImplementation(gc);
        board = new Board(displayDriver);

        movingByKey(stage.getScene());

        gc.fillText("CONTROLLERS: move: arrows; create: 1-circle, 2-square, 3-triangle;"
                + " increase: I, decrease: D; select: page up/down; "
                + "merge: A, clone: C, delete: Delete", 100, 50);

    }

    public void movingByKey(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        board.move(Board.Direction.UP);
                        break;
                    case RIGHT:
                        board.move(Board.Direction.RIGHT);
                        break;
                    case DOWN:
                        board.move(Board.Direction.DOWN);
                        break;
                    case LEFT:
                        board.move(Board.Direction.LEFT);
                        break;
                    case DIGIT1:
                        board.add(Shape.Type.CIRCLE);
                        break;
                    case DIGIT2:
                        board.add(Shape.Type.SQUARE);
                        break;
                    case DIGIT3:
                        board.add(Shape.Type.TRIANGLE);
                        break;
                    case PAGE_DOWN:
                        board.previousShape();
                        break;
                    case PAGE_UP:
                        board.nextShape();
                        break;
                    case D:
                        board.decrease();
                        break;
                    case I:
                        board.increase();
                        break;
                    case DELETE:
                        board.remove();
                        break;
                    case A:
                        board.aggregateShapes(true);
                    case C:
                        board.copySmth();
//                    case S:
//                        saveScene();
//                        break;
//                    case L:
//                        loadScene();
//                        break;
                }
            }
        });
    }

}
