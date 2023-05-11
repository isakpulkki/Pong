package pong.data;

import javafx.scene.text.Font;


/**
 * This is universal kind of interface for all the classes to get game's configurations like user interfaces width,
 * height etc. Which can be selected in the main-method
 */

public class Config {

    public static int height;
    public static int width;
    public static int playerHeight;
    public static int playerWidth;
    public static int ballRadius;
    public static int difficulty;
    public static int playerSpeed;
    public static int winScore;
    public static String style;
    public static Font font;

    public int getHeight() {
        return height;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        Config.font = font;
    }
}
