package org.academiadecodigobeaublue.gameobjects.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bernardo extends GameObjects {
    public Bernardo() {
        super(36, 30);
        this.picture = new Picture(getX(), getY(), "resources/Bernardo2.png");
    }
}
