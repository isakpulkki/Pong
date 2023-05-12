package pong.application.ui;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pong.data.Config;
import pong.utils.CustomButton;

/**
 * Creates Menu -scene for the application
 */

public class MenuUi {

    Button exit;
    Button settings;
    Button start;
    Stage stage;

    public MenuUi(Stage stage) {
        this.stage = stage;
    }

    /**
     * Creates MenuScene with all of its components and shows it
     */

    public void getMenuScene() {
        BorderPane borderPane = new BorderPane();
        VBox buttons = new VBox(20);
        getMenuButtons();
        buttons.getChildren().addAll(this.start, this.settings, this.exit);
        buttons.setAlignment(Pos.CENTER);
        VBox logo = new VBox(15);
        ImageView imageView = new ImageView("pngs/pong.png");
        imageView.setScaleX(0.9);
        imageView.setScaleY(0.9);
        logo.getChildren().add(imageView);
        logo.setAlignment(Pos.CENTER);
        logo.setPadding(new Insets(50, 10, 10, 10));
        borderPane.setTop(logo);
        borderPane.setCenter(buttons);
        borderPane.setStyle(Config.style);
        stage.setScene(new Scene(borderPane, Config.width, Config.height));
        stage.show();
    }

    /**
     * Makes the buttons for this scene, using my 'MenuButton' -class tu customize
     * them
     */

    public void getMenuButtons() {
        start = new CustomButton("Play").getCustomButton();
        start.setOnMouseClicked(e -> new GameUi(stage).getGameScene());
        settings = new CustomButton("Settings").getCustomButton();
        settings.setOnMouseClicked(e -> new SettingsUi(stage).getSettingsScene());
        exit = new CustomButton("Exit").getCustomButton();
        exit.setOnMouseClicked(e -> {
            Platform.exit();
        });
    }
}
