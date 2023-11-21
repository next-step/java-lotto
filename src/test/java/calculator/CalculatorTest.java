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
}
