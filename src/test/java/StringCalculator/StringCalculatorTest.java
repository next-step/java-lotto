package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void calculateTest() {
        String[] value = "1,3".split(",|;");
        MissionCalculator calculator = new MissionCalculator(value);
        assertThat(calculator.calculate());
    }
}
