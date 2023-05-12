package pong.application.ui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import pong.application.game.Graphics;
import pong.data.Config;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Creates Game -scene and sets the games keyboard listeners
 */

public class GameUi {

    Stage stage;

    public GameUi(Stage stage) {
        this.stage = stage;
    }

    /**
     * Creates PongScene and uses GameGraphics -class to draw the graphic's to
     * canvas
     */
    public void getGameScene() {
        Canvas canvas = new Canvas(Config.width, Config.height);
        canvas.setFocusTraversable(true);
        javafx.scene.canvas.GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Graphics graphics = new Graphics(graphicsContext);
        KeyFrame keyframe = new KeyFrame(Duration.millis(6), e -> {
            try {
                graphics.getGraphics();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                ex.printStackTrace();
            }
        });
        Timeline timeline = new Timeline(keyframe);
        timeline.setCycleCount(Timeline.INDEFINITE);
        setKeyListenersOnPressed(graphics, canvas, timeline);
        setKeyListenersOnReleased(graphics, canvas);
        StackPane stackPane = new StackPane(canvas);
        stackPane.setStyle(Config.style);
        stage.setScene(new Scene(stackPane));
        stage.show();
        timeline.play();
    }

    /**
     * Creates listeners for key presses
     */
    public void setKeyListenersOnPressed(Graphics graphics, Canvas canvas, Timeline timeline) {
        canvas.setOnKeyPressed(e -> {
            if (e.getCode() != KeyCode.ESCAPE) {
                if (e.getCode() == KeyCode.DOWN) {
                    graphics.getGameLogic().setDownPressed(true);
                } else if (e.getCode() == KeyCode.UP) {
                    graphics.getGameLogic().setUpPressed(true);
                } else if (e.getCode() == KeyCode.S) {
                    graphics.getGameLogic().setsPressed(true);
                } else if (e.getCode() == KeyCode.W) {
                    graphics.getGameLogic().setwPressed(true);
                }
            } else {
                timeline.stop();
                new MenuUi(stage).getMenuScene();
                stage.show();
            }
            graphics.getGameLogic().setGameStarted(true);
        });
    }

    /**
     * Creates listeners for key releases
     */
    public void setKeyListenersOnReleased(Graphics graphics, Canvas canvas) {
        canvas.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.DOWN) {
                graphics.getGameLogic().setDownPressed(false);
            } else if (e.getCode() == KeyCode.UP) {
                graphics.getGameLogic().setUpPressed(false);
            } else if (e.getCode() == KeyCode.S) {
                graphics.getGameLogic().setsPressed(false);
            } else if (e.getCode() == KeyCode.W) {
                graphics.getGameLogic().setwPressed(false);
            }
        });
    }

}
