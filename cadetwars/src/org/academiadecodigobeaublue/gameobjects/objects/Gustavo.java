package org.academiadecodigobeaublue.gameobjects.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Gustavo extends GameObjects {
    public Gustavo() {

        super(40, 10);
        this.picture = new Picture(getX(), getY(), "resources/Gustavo2.png");
    }
}
