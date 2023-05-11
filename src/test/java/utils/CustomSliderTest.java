package utils;

import de.saxsys.javafx.test.JfxRunner;
import javafx.scene.control.Slider;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.utils.CustomSlider;

import static junit.framework.TestCase.assertEquals;

@RunWith(JfxRunner.class)
public class CustomSliderTest {
    Slider slider;

    public CustomSliderTest() {
        this.slider = new CustomSlider(10, 100, 10).getCustomSlider();
    }

    @Test
    public void testSliderHasRightValue() {
        slider.setValue(20.0);
        assertEquals(20.0, slider.getValue());
    }

    @Test
    public void testSliderMinIsRight() {
        assertEquals(10.0, slider.getMin());
    }

    @Test
    public void testSliderMaxIsRight() {
        assertEquals(100.0, slider.getMax());
    }
}