package org.academiadecodigobeaublue.menu;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuRepresentation {

    private Picture menuBackground;
    private Picture menuLoading;
    private Picture instructions;
    private Picture execute76;
   // private Sound loading;
    //private Sound menu;

    public MenuRepresentation() {
        this.menuBackground = new Picture(10,10,"resources/menu.png");
        this.menuLoading = new Picture(10,10,"resources/Menuloading.png");
        this.instructions = new Picture(10,10,"resources/instructions.png");
        this.execute76 = new Picture(10,10,"resources/loading.png" );
        //loading = new Sound();

    }



    public void initMenu() throws InterruptedException {
        menuLoading.draw();
        Thread.sleep(600);
        //loading.start(true);
        Thread.sleep(5500);
        menuLoading.delete();
    }

    public void mainMenu() {
        menuBackground.draw();
    }

    /*public void stopMenuSound() {
        menu.stop();
} */

    /* public void menuSound() {
        menu = new Sound();
        menu.setLoop(10);
        menu.play(true);
    } */

    public void instructions () {
        instructions.draw();
    }

    public void exec76(){
        execute76.draw();
    }


    public void instructionsDeleted () {
        instructions.delete();
    }
}