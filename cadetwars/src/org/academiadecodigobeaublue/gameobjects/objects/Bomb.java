package org.academiadecodigobeaublue.gameobjects.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bomb extends GameObjects {
    public Bomb() {
        super(30, -100);
        this.picture = new Picture(getX(), getY(), "resources/BOMBA.png");
    }
}

