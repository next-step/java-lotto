package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("두 숫자를 더한다")
    void addTwoNumber() {
        int num1 = 1;
        int num2 = 2;

        assertThat(Calculator.add(num1, num2)).isEqualTo(3);
    }
}
