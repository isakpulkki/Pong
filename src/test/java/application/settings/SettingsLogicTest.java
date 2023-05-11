package application.settings;

import de.saxsys.javafx.test.JfxRunner;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.application.settings.SettingsLogic;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JfxRunner.class)
public class SettingsLogicTest {
    SettingsLogic settingsLogic;
    ArrayList<Slider> sliders;

    @Before
    public void SettingsLogic(){
        settingsLogic = new SettingsLogic();
        sliders = new ArrayList<>();
        sliders.add(settingsLogic.playerSizeSlider());
        sliders.add(settingsLogic.ballSizeSlider());
        sliders.add(settingsLogic.difficultySlider());
    }
    @Test
    public void creatingSlidersReturnsSliders(){
        assertEquals(3, sliders.size());
    }
}
