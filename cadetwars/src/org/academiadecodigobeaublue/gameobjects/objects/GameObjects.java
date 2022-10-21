package org.academiadecodigobeaublue.gameobjects.objects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigobeaublue.gameobjects.Background;
import org.academiadecodigobeaublue.gameobjects.ObjectFactory;


public class GameObjects {

    private boolean sliced = false;

    private GameObjects[] gameObjects;
    Picture picture;
    Rectangle hitBox;

    private int x;
    private int y;

    private int speed;

    private int slicedPoints;

    private ObjectType type;


    public GameObjects(int speed, int slicedPoints) {
        this.speed = speed;
        this.slicedPoints = slicedPoints;
        this.type = type;
        y = (int) (Math.random() * (Background.BACKGROUNDHEIGHT - 100));
        x = (int) (Math.random() * (Background.BACKGROUNDWIDTH - 100));
        hitBox = new Rectangle(this.x, this.y, 70, 70);
    }

    public void move() throws InterruptedException {
        // while (picture.getY() <= 490) {
            picture.translate(0, speed);
            hitBox.translate(0, speed);
            Thread.sleep(1000);
            picture.delete();
            hitBox.delete();
        }


    public int getX() {
        return hitBox.getX();
    }

    public int getY() {
        return hitBox.getY();
    }

    public int getSlicedPoints() {
        return slicedPoints;
    }
    public boolean isSliced() {
        return sliced;
    }
    public void setSliced(boolean sliced) {
        this.sliced = sliced;
        picture.delete();
    }
    public void show() {
        picture.draw();
    }
}