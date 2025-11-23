package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @DisplayName("배열을 연산한다")
    @Test
    void calculate() {
        String[] tokens = {"1", "+", "2", "+", "3"};
        assertThat(StringCalculator.calculate(tokens)).isEqualTo(6);
    }
}
