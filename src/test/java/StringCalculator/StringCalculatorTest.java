package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void calculateTest_TwoNumbers() {
        String[] value = "1,3".split(",|;");
        MissionCalculator calculator = new MissionCalculator(value);
        assertThat(calculator.calculate()).isEqualTo(4);
    }

    @Test
    void calculateTest_ThreeNumbers() {
        String[] value = "1,3;5".split(",|;");
        MissionCalculator calculator = new MissionCalculator(value);
        assertThat(calculator.calculate()).isEqualTo(9);
    }
}
