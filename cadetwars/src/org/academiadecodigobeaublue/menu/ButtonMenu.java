package org.academiadecodigobeaublue.menu;

public class ButtonMenu {

    public static Button getNewButton(ButtonType type) {
        return new Button(type.getStartX(), type.getStartY(), type.getEndX(), type.getEndY());
    }
}
