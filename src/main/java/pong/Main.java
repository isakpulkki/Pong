package pong;


import javafx.scene.text.Font;
import pong.data.Config;
import pong.data.ConfigDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Launches the start-method's main and sets applications configurations
 */

public class Main {
    /**
     * Launches the start-method's main which starts the application, had a bug with only one main-method
     */

    public static void main(String[] args) throws IOException {
        setConfig();
        Start.main(args);
    }

    /**
     * This sets the Config-class values from the config.properties -file inside resources' folder, rest of the configs
     * come from the SQLite database
     */
    public static void setConfig() throws IOException {
        Properties prop = new Properties();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("config.properties");
        prop.load(inputStream);
        Config.height = Integer.parseInt(prop.getProperty("height"));
        Config.width = Integer.parseInt(prop.getProperty("width"));
        Config.style = prop.getProperty("style");
        Config.playerWidth = Integer.parseInt(prop.getProperty("playerWidth"));
        Config.playerSpeed = Integer.parseInt(prop.getProperty("playerSpeed"));
        Config.font = Font.font(Double.parseDouble(prop.getProperty("font")));
        Config.winScore = Integer.parseInt(prop.getProperty("winScore"));
        //Connects or creates our SQLite-database to this application
        new ConfigDao("config");
    }
}