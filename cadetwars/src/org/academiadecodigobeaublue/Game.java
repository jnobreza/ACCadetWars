package org.academiadecodigobeaublue;

import org.academiadecodigobeaublue.gameobjects.ObjectFactory;
import org.academiadecodigobeaublue.gameobjects.objects.GameObjects;
import org.academiadecodigobeaublue.gameobjects.Background;
import org.academiadecodigobeaublue.menu.Menu;
import org.academiadecodigobeaublue.menu.Sound;


public class Game {

    private GameObjects[] gameObjects;

    private Background background;

    private Integer score;

    private ClickDetector clickDetector;

    private boolean exit;

    Sound menuSound = new Sound("/resources/inicio.wav");

    public Game() throws InterruptedException {
        menuSound.play(true);
        menuSound.setLoop(5);
        Menu menu = new Menu();
        menu.menuSelection();
        init();
        updateScore();
        gameOver();
        updateScore();
    }

    public void createGameObjects() {
        for (int i = 0; i < gameObjects.length; i++) {
            gameObjects[i] = ObjectFactory.getNewGameObjects();
        }
    }

    public void moveAll() throws InterruptedException {
        for (int i = 0; i < gameObjects.length; i++) {
            gameObjects[i].show();
            gameObjects[i].move();
            background.scoreUpdate(clickDetector.checkObjectClicked());
        }
    }

    public void init() throws InterruptedException {
        background = new Background();
        background.init();
        score = 0;
        gameObjects = new GameObjects[50];
        background.scoreInit(score);
        background.drawScore();
        createGameObjects();
        clickDetector = new ClickDetector(gameObjects);
        moveAll();
    }

    public void updateScore() {
        if (score == 0) {
            background.scoreUpdate(clickDetector.checkObjectClicked());
            background.drawScore();
        }
    }

    private void gameOver() {
        background.gameOver();
        exit = true;
    }
}