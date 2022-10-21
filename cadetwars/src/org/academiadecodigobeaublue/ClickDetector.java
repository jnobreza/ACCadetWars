package org.academiadecodigobeaublue;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigobeaublue.gameobjects.objects.GameObjects;

public class ClickDetector implements MouseHandler {

    private Mouse mouse;
    private int x;
    private int y;
    private GameObjects[] objects;
    private int score = 0;


    ClickDetector(GameObjects[] gameObjects) {
        this.mouse = new Mouse(this);
        this.objects = gameObjects;
        addEventListener();
    }

    void addEventListener() {
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        x = (int) mouseEvent.getX();
        y = (int) mouseEvent.getY();
        checkObjectClicked();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    public int checkObjectClicked() {
        for (GameObjects object : objects) {
            if (object.isSliced() || x < object.getX() || y < object.getY()) {
            } else if (x > object.getX() + 70 || y > object.getY() + 70) {
                ;
            } else {
                object.setSliced(true);
                score += object.getSlicedPoints();
                System.out.println(score);
            }
        }
        return score;
    }
}


