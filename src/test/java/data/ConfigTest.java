package data;

import de.saxsys.javafx.test.JfxRunner;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.utils.CustomButton;
import pong.data.Config;

import static org.junit.Assert.assertEquals;

@RunWith(JfxRunner.class)
public class ConfigTest {
    Config config;

    public ConfigTest() {
        config = new Config();
    }


    @Test
    public void changeHeight() {
        Config.height = 2000;
        assertEquals(2000, config.getHeight());
    }

    @Test
    public void changeFont() {
        Font font = Font.font("Times New Roman", 20);
        this.config.setFont(font);
        assertEquals(font, config.getFont());
    }

    @Test
    public void changeFontAndButtonChangesToo() {
        Config.font = Font.font("Verdana", 20);
        CustomButton menuButton = new CustomButton("Testi");
        Button test = menuButton.getCustomButton();
        assertEquals(test.getFont(), config.getFont());
    }
}
