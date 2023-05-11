package pong.application.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import pong.application.game.entities.Ball;
import pong.application.game.entities.Player;
import pong.data.Config;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * This class creates graphics for the game and holds games logic
 */

public class Graphics {

    GraphicsContext graphicsContext;
    GameLogic logic;
    Player leftPlayer;
    Player rightPlayer;
    Ball ball;
    int width = Config.width;
    int height = Config.height;
    int playerWidth = Config.playerWidth;
    int playerHeight = Config.playerHeight;

    public Graphics(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        logic = new GameLogic();
    }

    /**
     * This method initializes the games graphics and makes the calls for games logic
     */
    public void getGraphics() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        logic.getGameLogic();
        leftPlayer = logic.getLeftPlayer();
        rightPlayer = logic.getRightPlayer();
        ball = logic.getBall();
        graphicsContext.clearRect(0, 0, width, height);
        graphicsContext.setFont(Config.font);
        drawMiddleLine();
        drawPlayers();
        drawScores();
        checkIfGameIsStarted();
    }

    /**
     * Draws scores
     */
    public void drawScores() {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        String score = leftPlayer.getScore() + " - " + rightPlayer.getScore();
        graphicsContext.fillText(score, (width / 2), 40);
    }

    /**
     * Draws middle line
     */
    public void drawMiddleLine() {
        graphicsContext.setFill(Color.RED);
        graphicsContext.setLineWidth(5);
        graphicsContext.setLineDashes(20);
        graphicsContext.strokeLine((width / 2), 0, width / 2, height);
    }

    /**
     * Draws the players
     */
    public void drawPlayers() {
        graphicsContext.fillRect(leftPlayer.getxPos(), leftPlayer.getyPos(), playerWidth, playerHeight);
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillRect(rightPlayer.getxPos(), rightPlayer.getyPos(), playerWidth, playerHeight);
        graphicsContext.setStroke(Color.WHITE);
    }

    /**
     * Checks if game is in progress, starting or paused
     */

    public void checkIfGameIsStarted() {
        if (logic.isGameStarted()) {
            if (logic.isWinnerLeft() || logic.isWinnerRight()) {
                logic.setWinnerLeft(false);
                logic.setWinnerRight(false);
            }
            graphicsContext.fillOval(ball.getxPos(), ball.getyPos(), Config.ballRadius, Config.ballRadius);
        } else {
            if (logic.gameInProgress) {
                pauseGame(graphicsContext);
            } else {
                gameStarting(graphicsContext);
            }
        }
    }

    /**
     * This method pauses the game in progress when someone scores
     */
    public void pauseGame(GraphicsContext graphicsContext) {
        graphicsContext.fillText("Press a button to continue", width / 2, height / 2);
        checkForWinners(graphicsContext);
    }

    /**
     * Checks if we have winners
     */
    private void checkForWinners(GraphicsContext graphicsContext) {
        Image image;
        if (logic.isWinnerLeft()) {
            graphicsContext.setFill(Color.RED);
            graphicsContext.fillText("Winner!", width / 3, (height / 4) + 55);
            image = new Image("/pngs/trophy.png", 100, 100, false, false);
            graphicsContext.drawImage(image, (width / 5), (height / 4));
        }
        if (logic.isWinnerRight()) {
            graphicsContext.setFill(Color.BLUE);
            graphicsContext.fillText("Winner!", width - (width / 5), (height / 4) + 55);
            image = new Image("/pngs/trophy.png", 100, 100, false, false);
            graphicsContext.drawImage(image, width - (width / 3), (height / 4));
        }
    }

    /**
     * Draws gameStarting screen, where we have instructions for the game etc.
     */
    public void gameStarting(GraphicsContext graphicsContext) {

        Image image = new Image("/pngs/up.png", 80, 80, false, false);
        graphicsContext.fillText("Press a button to start", width / 2, (height) / 2);
        graphicsContext.drawImage(image, width - image.getWidth() * 2, (height - image.getHeight() / 2) / 2 - (image.getHeight() / 1.5));
        image = new Image("/pngs/down.png", 80, 80, false, false);
        graphicsContext.drawImage(image, width - image.getWidth() * 2, (height - image.getHeight() / 2) / 2 + (image.getHeight() / 1.5));
        image = new Image("/pngs/w.png", 80, 80, false, false);
        graphicsContext.drawImage(image, image.getWidth(), (height - image.getHeight() / 2) / 2 - image.getHeight() / 1.5);
        image = new Image("/pngs/s.png", 80, 80, false, false);
        graphicsContext.drawImage(image, image.getWidth(), (height - image.getHeight() / 2) / 2 + image.getHeight() / 1.5);
        image = new Image("/pngs/esc.png", 80, 80, false, false);
        graphicsContext.drawImage(image, width / 2 - (image.getWidth() / 2), ((height - image.getHeight() * 1.2)));
        graphicsContext.fillText("Main menu", width / 2, (height - (image.getHeight() * 1.5)));
        checkForWinners(graphicsContext);
    }

    public GameLogic getGameLogic() {
        return logic;
    }

}
