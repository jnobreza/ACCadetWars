package org.academiadecodigobeaublue.gameobjects.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Mariana extends GameObjects {
    public Mariana() {
        super(36, 20);
        this.picture = new Picture(getX(), getY(), "resources/Mariana2.png");
    }
}
