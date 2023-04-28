package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("계산")
    void calculate() {
        String input = "2 + 3 * 4 / 2";
        StringCalculator calculator = new StringCalculator(input);

        assertThat(calculator.calculate()).isEqualTo(10);
    }
}
