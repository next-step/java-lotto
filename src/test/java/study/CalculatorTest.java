package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
        var expression = "2 + 3";

        var result = Calculator.calculate(expression);

        Assertions.assertThat(result).isEqualTo(5);
    }
}
