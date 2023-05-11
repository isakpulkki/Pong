package utils;

import de.saxsys.javafx.test.JfxRunner;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.data.Config;
import pong.utils.CustomButton;

import static org.junit.Assert.assertEquals;

@RunWith(JfxRunner.class)
public class CustomButtonTest {
    Button button;
    public CustomButtonTest(){
        this.button = new CustomButton("testi").getCustomButton();
    }

    @Test
    public void testButtonFont(){
        assertEquals(Config.font, button.getFont());
    }
    @Test
    public void testButtonColor(){
        assertEquals(Color.WHITE, button.getTextFill());
    }
}
