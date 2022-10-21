package org.academiadecodigobeaublue.gameobjects.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Baljeet extends GameObjects {
    public Baljeet() {
        super(36, 70);
        this.picture = new Picture(getX(), getY(), "resources/Baljeet1.png");
    }

}
