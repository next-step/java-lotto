package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈을 할 수 있다.")
    void plus() {
        // given
        Calculator calculator = new Calculator();
        String given = "1 + 3";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("뺼셈을 할 수 있다.")
    void minus() {
        // given
        Calculator calculator = new Calculator();
        String given = "2 - 4";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(-2);
    }

    @Test
    @DisplayName("곱셈을 할 수 있다.")
    void multiply() {
        // given
        Calculator calculator = new Calculator();
        String given = "3 * 5";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("나눗셈을 할 수 있다.")
    void divide() {
        // given
        Calculator calculator = new Calculator();
        String given = "15 / 3";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(5);
    }
}
