package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("두 숫자를 더한다.")
    void 덧셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("두 숫자를 뺀다.")
    void 뺄셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.subtract(3, 2)).isEqualTo(1);
    }
}
