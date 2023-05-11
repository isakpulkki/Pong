package application.game;

import de.saxsys.javafx.test.JfxRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.Main;
import pong.application.game.GameLogic;
import pong.data.Config;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JfxRunner.class)
public class GameLogicTest {
    GameLogic gameLogic;

    @Before
    public void setGameLogic() throws IOException {
        Main.setConfig();
        gameLogic = new GameLogic();
        gameLogic.setGameStarted(false);
        gameLogic.getGameLogic();
    }

    @Test
    public void checkLeftPlayerWinsScoreResetsScores() {
        gameLogic.resetPlayersScore();
        gameLogic.getLeftPlayer().setScore(Config.winScore);
        gameLogic.checkForScores();
        assertEquals(0, gameLogic.getLeftPlayer().getScore());
    }
    @Test
    public void checkRightPlayerWinsResetsScores() {
        gameLogic.resetPlayersScore();
        gameLogic.getRightPlayer().setScore(Config.winScore);
        gameLogic.checkForScores();
        assertEquals(0, gameLogic.getRightPlayer().getScore());
    }

    @Test
    public void checkPressingKeyMovesPlayer() {
        gameLogic.setDownPressed(false);
        gameLogic.setUpPressed(true);
        int pos = gameLogic.getRightPlayer().getyPos();
        gameLogic.checkMovement();
        assertEquals(pos - Config.playerSpeed, gameLogic.getRightPlayer().getyPos());
    }

    @Test
    public void checkPlayerHitReversesDirection(){
        gameLogic.getBall().setxSpeed(-1);
        gameLogic.getBall().setxPos(gameLogic.getLeftPlayer().getxPos() - 1);
        gameLogic.checkForHits();
        assertEquals(1, gameLogic.getBall().getxSpeed());
    }

    @Test
    public void gameInProgressIsTrue(){
        gameLogic.getLeftPlayer().setScore(1);
        gameLogic.checkIfGameInProgress();
        assertTrue(gameLogic.gameInProgress);

    }
}