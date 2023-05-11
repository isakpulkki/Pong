package pong.utils;

import javafx.scene.control.Slider;
import pong.data.Config;

/**
 * Creates customized slider
 */
public class CustomSlider extends Config {
    int start;
    int stop;
    int units;

    public CustomSlider(int start, int stop, int units) {
        this.start = start;
        this.stop = stop;
        this.units = units;
    }

    /**
     * Creates and returns slider with custom configurations
     */

    public Slider getCustomSlider() {
        Slider slider = new Slider(start, stop, 1);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(units);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setMaxWidth(width / 5);
        slider.setShowTickLabels(true);
        //Some custom css to get the slider to match the application's theme
        slider.getStylesheets().add(getClass().getResource("/slider.css").toExternalForm());
        return slider;
    }

}
