package pong.application.game.entities;

import pong.data.Config;

/**
 * Player in the game
 */
public class Player {
    private int score;
    private final int xPos;
    private int yPos;

    public void setScore(int score) {
        this.score = score;
    }

    public Player(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.score = 0;
    }

    /**
     * increase players score
     */
    public void increaseScore() {
        this.score++;
    }

    /**
     * Increase y-axis
     */
    public void increaseY() {
        if ((this.yPos + Config.playerHeight) > Config.height) {
            this.yPos = Config.height - Config.playerHeight;
        }
        this.yPos += Config.playerSpeed;
    }

    /**
     * Decrease y-axis
     */
    public void decreaseY() {

        if (this.yPos < 0) {
            this.yPos = 0;
        }
        this.yPos -= Config.playerSpeed;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getScore() {
        return this.score;
    }
}
