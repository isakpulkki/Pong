package application.entities;

import de.saxsys.javafx.test.JfxRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.application.game.entities.Ball;
import static org.junit.Assert.assertEquals;

@RunWith(JfxRunner.class)
public class BallTest {
    Ball ball = new Ball();

@Test
    public void movingBallMovesBall(){
        int x = this.ball.getxPos() + this.ball.getxSpeed();
        int y = this.ball.getyPos() + this.ball.getySpeed();
        this.ball.moveBall();
        assertEquals(this.ball.getxPos(), x);
        assertEquals(this.ball.getyPos(), y);
    }

    @Test
    public void reversingYWhenHitsTopOrBottom(){
    ball.setySpeed(-1);
    int y = -1 * ball.getySpeed();
    ball.setyPos(-1);
    if (ball.hitsTopOrBottom()){
        ball.reverseYdirection();
    };
    assertEquals(y, ball.getySpeed());
    }

    @Test
    public void histPlayerReversesDirection(){
    ball.setyPos(0);
    ball.setxPos(-1);
    ball.setxSpeed(-10);
    int x = -1 * ball.getxSpeed();
    ball.hitsPlayer(0);
    assertEquals(x, ball.getxSpeed());
    }
}
