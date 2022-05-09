import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.InputEvent;

public class Controller extends Application {
    //class data members
    GUI gui;
    Robot bot;
    private int count;


    /*JavaFX Standard init(), start(Stage), main(args[])*/
    public void init() {
        count = 1;
        gui = new GUI();
        initBot();

        gui.addLeftHandler(new LMBHandler());
        gui.addRightHandler(new RMBHandler());
    }

    public void start(Stage stage) {
        stage.setMaxHeight(200);
        stage.setMaxWidth(250);
        stage.setResizable(false);

        stage.setTitle("Auto-Clicker-GUI");
        stage.setScene(new Scene(gui));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    /*JavaFX Standard init(), start(Stage), main(args[])*/

    //Instantiate Bot
    public void initBot() {
        try {
            bot = new Robot();
        } catch (AWTException e) {

        }
    }

    //my java robot functions
    public void leftClick() {
        try {
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(150);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(150);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rightClick() {
        try {
            bot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            Thread.sleep(150);
            bot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            Thread.sleep(150);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCount() {
        count = gui.getCountTxtNum();
    }

    void runLeftClicks(){
        try {
            setCount();
            Thread.sleep(1000);
            for (int i = 0; i < count; i++) {
                leftClick();
                System.out.println(count);
            }
        } catch (Exception e) {
            count = gui.getCountTxtNum();
        }
    }

    void runRightClicks() {
        try {
            setCount();
            Thread.sleep(1000);
            for (int i = 0; i < count; i++) {
                rightClick();
                System.out.println(count);
            }
        } catch (Exception e) {
            count = gui.getCountTxtNum();
        }
    }

    class LMBHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            setCount();
            if (count != 0) {
                try {
                    runLeftClicks();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class RMBHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event) {
            setCount();
            if (count != 0) {
                try {
                    runRightClicks();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
