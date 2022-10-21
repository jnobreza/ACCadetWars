package org.academiadecodigobeaublue.menu;

public enum ButtonType {

    START (923,334,1036,370),
    INFO(923,390,1221,421),
    EXIT(923,711,1021,778),
    BACK(64,615,193,650);


    private int startX;
    private int startY;
    private int endX;
    private int endY;

    ButtonType(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }
}
