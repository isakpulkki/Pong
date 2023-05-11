package pong;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pong.application.ui.MenuUi;

/**
 * Launches the actual application and sets MenuScene as the first scene, two mains got rid of a bug
 */

public class Start extends Application {
    /**
     * This method launches the actual application
     */

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the stage
     */

    public void start(Stage stage) {
        stage.setTitle("Pong");
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.getIcons().add(new Image(getClass().getResource("/pngs/icon.png").toExternalForm()));
        new MenuUi(stage).getMenuScene();
    }

}
