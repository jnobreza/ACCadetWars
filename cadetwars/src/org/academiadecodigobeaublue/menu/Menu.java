package org.academiadecodigobeaublue.menu;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Menu {

    private MenuRepresentation menuRepresentation;
    private int mouseX;
    private int mouseY;
    private Button start;
    private Button instructions;
    private Button exit;
    private Button back;

    private boolean specialScreen;
    private boolean menuSelection;

    public Menu() throws InterruptedException {
        new MenuMouse();
        menuRepresentation = new MenuRepresentation();
        loading();
        start = ButtonMenu.getNewButton(ButtonType.START);
        instructions = ButtonMenu.getNewButton(ButtonType.INFO);
        exit = ButtonMenu.getNewButton(ButtonType.EXIT);
        back = ButtonMenu.getNewButton(ButtonType.BACK);
        menuSelection = false;
        specialScreen = false;

    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void menuSelection() throws InterruptedException {

        while (!menuSelection) {
            Thread.sleep(1);
            if(specialScreen){
                if((getMouseX() >= back.getStartX() && getMouseX() <= back.getEndX()) && (getMouseY() >= back.getStartY() && getMouseY() <= back.getEndY())) {
                    menuRepresentation.instructionsDeleted();
                    Thread.sleep(200);
                    specialScreen = false;
                    mainMenu();
                }
            }
            if ((getMouseX() >= start.getStartX() && getMouseX() <= start.getEndX()) &&
                    (getMouseY() >= start.getStartY() && getMouseY() <= start.getEndY())) {
                //menuRepresentation.stopMenuSound();
                menuRepresentation.exec76();
                Thread.sleep(5000);
                menuSelection = true;
            }
            if ((getMouseX() >= instructions.getStartX() && getMouseX() <= instructions.getEndX()) &&
                    (getMouseY() >= instructions.getStartY() && getMouseY() <= instructions.getEndY())) {
                specialScreen = true;
                instructions();
            }
            if ((getMouseX() >= exit.getStartX() && getMouseX() <= exit.getEndX()) &&
                    (getMouseY() >= exit.getStartY() && getMouseY() <= exit.getEndY())) {

            }
        }
    }

    private void loading() throws InterruptedException {
        menuRepresentation.initMenu();
        //menuRepresentation.menuSound();
        mainMenu();
    }


    private void mainMenu() {
        menuRepresentation.mainMenu();
    }

    private void instructions() {
        menuRepresentation.instructions();
    }

    private class MenuMouse implements MouseHandler {

        private Mouse mouse1;

        MenuMouse() {
            this.mouse1 = new Mouse(this);
            addEventListener();
        }

        void addEventListener() {
            mouse1.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            mouseX =(int)  e.getX();
            mouseY =(int)  e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}