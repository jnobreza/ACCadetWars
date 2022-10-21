package org.academiadecodigobeaublue.gameobjects;

import org.academiadecodigobeaublue.gameobjects.objects.*;

public class ObjectFactory {

    private static GameObjects gameObject;

    public static GameObjects getNewGameObjects() {

        int random = (int) (Math.random() * ObjectType.values().length);

        ObjectType objectType = ObjectType.values()[random];

        switch (objectType){
            case GUSTAVO:
                 gameObject = new Gustavo();
                break;
            case SARA:
                gameObject = new Sara();
                break;
            case BEATRIZ:
                gameObject = new Beatriz();
                break;
            case BERNARDO:
                gameObject = new Bernardo();
                break;
            case CAROL:
                gameObject = new Carol();
                break;
            case MARIANA:
                gameObject = new Mariana();
                break;
            case BALJEET:
                gameObject = new Baljeet();
                break;
            case BOMB:
                gameObject = new Bomb();
                break;
        }
        return gameObject;
    }
}




