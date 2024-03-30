package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    @DisplayName("연산자 우선순위에 상관없이 순차적으로 계산한다")
    void calculate_순차적연산수행() {
        String formula = "2 + 3 * 4 / 2";
        int result = Calculator.calculate(formula);

        assertThat(result).isEqualTo(10);
    }
}