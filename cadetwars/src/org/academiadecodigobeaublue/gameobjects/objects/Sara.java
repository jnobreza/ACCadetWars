package org.academiadecodigobeaublue.gameobjects.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sara extends GameObjects {
    public Sara() {
        super(40, 10);
        this.picture = new Picture(getX(), getY(), "resources/Sara2.png");
    }
}
