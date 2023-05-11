package pong.application.game;
import pong.application.game.entities.Ball;
import pong.application.game.entities.Player;
import pong.data.Config;

/**
 * Contains the games logic
 */
public class GameLogic {

    private boolean gameStarted;
    private final Player leftPlayer;
    private final Player rightPlayer;
    private Ball ball;
    private boolean wPressed;
    private boolean sPressed;
    private boolean upPressed;
    private boolean downPressed;
    private boolean winnerLeft;
    private boolean winnerRight;
    public boolean gameInProgress;

    public GameLogic() {
        leftPlayer = new Player(8, Config.height / 2 - (100 / 2));
        rightPlayer = new Player(Config.width - Config.playerWidth - 8, Config.height / 2 - (100 / 2));
        this.gameStarted = false;

    }

    /**
     * Controls the game logic
     */
    public void getGameLogic() {

        checkMovement();
        checkIfGameInProgress();
        if (gameStarted) {
            ball.moveBall();
        } else {
            this.ball = new Ball();
        }
        if (this.ball.hitsTopOrBottom()) {
            this.ball.reverseYdirection();
        }
        checkForHits();
        checkForScores();
    }

    /**
     * Checks if the game is in progress or just starting
     */
    public void checkIfGameInProgress() {
        if (leftPlayer.getScore() > 0 || rightPlayer.getScore() > 0) {
            gameInProgress = true;
            return;
        }
        gameInProgress = false;
    }

    /**
     * Checks if players are moving currently or not and moves them if yes
     */
    public void checkMovement() {
        if (wPressed) {
            this.leftPlayer.decreaseY();
        }
        if (sPressed) {
            this.leftPlayer.increaseY();
        }
        if (downPressed) {
            this.rightPlayer.increaseY();
        }
        if (upPressed) {
            this.rightPlayer.decreaseY();
        }
    }

    /**
     * Resets players scores
     */
    public void resetPlayersScore() {
        leftPlayer.setScore(0);
        rightPlayer.setScore(0);
    }

    /**
     * Checks if player has scored
     */
    public void checkForScores() {
        if (this.ball.getxPos() < this.leftPlayer.getxPos() - Config.playerWidth) {
            rightPlayer.increaseScore();
            gameStarted = false;
        }
        if (rightPlayer.getScore() == Config.winScore) {
            resetPlayersScore();
            winnerRight = true;
        }
        if (this.ball.getxPos() > this.rightPlayer.getxPos() + Config.playerWidth) {
            leftPlayer.increaseScore();
            gameStarted = false;
        }
        if (leftPlayer.getScore() == Config.winScore) {
            resetPlayersScore();
            winnerLeft = true;
        }
    }

    /**
     * Checks if player has hit the ball
     */
    public void checkForHits() {

        if (this.ball.getxPos() <= this.leftPlayer.getxPos() + Config.playerWidth) {
            this.ball.hitsPlayer(this.leftPlayer.getyPos());

        }
        if (this.ball.getxPos() + Config.ballRadius >= this.rightPlayer.getxPos()) {
            this.ball.hitsPlayer(this.rightPlayer.getyPos());
        }
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public boolean isWinnerLeft() {
        return winnerLeft;
    }

    public boolean isWinnerRight() {
        return winnerRight;
    }

    public void setWinnerLeft(boolean winnerLeft) {
        this.winnerLeft = winnerLeft;
    }

    public void setWinnerRight(boolean winnerRight) {
        this.winnerRight = winnerRight;
    }

    public Player getLeftPlayer() {
        return leftPlayer;
    }

    public Player getRightPlayer() {
        return rightPlayer;
    }

    public Ball getBall() {
        return ball;
    }


    public void setwPressed(boolean wPressed) {
        this.wPressed = wPressed;
    }


    public void setsPressed(boolean sPressed) {
        this.sPressed = sPressed;
    }


    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }


    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }
}
