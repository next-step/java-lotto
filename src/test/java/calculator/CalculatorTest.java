package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @DisplayName("덧셈 연산이 잘 수행되는지")
    @Test
    void additionTest() {
        assertThat(Calculator.calculate("1 + 2")).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산이 잘 수행되는지")
    @Test
    void subtractionTest() {
        assertThat(Calculator.calculate("2 - 1")).isEqualTo(1);
    }
}
