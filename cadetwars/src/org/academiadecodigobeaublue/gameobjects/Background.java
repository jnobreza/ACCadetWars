package org.academiadecodigobeaublue.gameobjects;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Background {

    private Picture background;
    private Picture overlay;

    private Text displayScore;

    public static int BACKGROUNDWIDTH;
    public static int BACKGROUNDHEIGHT;

    public Background() {
        background = new Picture(10, 10, "resources/fundojogo.png");
        overlay = new Picture();
        this.BACKGROUNDWIDTH = background.getWidth();
        this.BACKGROUNDHEIGHT = background.getHeight() - 130;
    }

    public void init() {
        background.draw();
        //mensagem do Moreira
        //overlay.draw();
    }

    public void scoreInit(Integer score) {
        displayScore = new Text(240, 672, score.toString());
        displayScore.setColor(Color.WHITE);
        displayScore.grow(20, 20);
    }
    public void drawScore() {
        displayScore.draw();
    }
    public void scoreUpdate(Integer newScore) {
        displayScore.setText(newScore.toString());
    }

    public void gameOver() {
        Picture gameOver = new Picture(10, 10, "resources/gameover.png");
        gameOver.draw();
    }
}
