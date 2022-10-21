package org.academiadecodigobeaublue.gameobjects.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Carol extends GameObjects {
    public Carol() {
        super(36, 20);
        this.picture = new Picture (getX(), getY(), "resources/Carol2.png");
    }
}
