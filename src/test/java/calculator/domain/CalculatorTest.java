package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @Test
    @DisplayName("계산기능/4/4")
    void calculateOneParam() {
        // given
        Calculator calculator = new Calculator(Arrays.asList("4"));

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("계산기능/4+2/6")
    void calculateSimple() {
        // given
        Calculator calculator = new Calculator(Arrays.asList("4", "+", "2"));

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("계산기능/ 2+3*4/2-1 / 9")
    void calculateSequential() {
        // given
        Calculator calculator = new Calculator(Arrays.asList("2", "+", "3", "*", "4", "/", "2", "-", "1"));

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("계산실패/ 2+3* / IllegalArgumentException")
    void calculateBlank() {
        // given
        Calculator calculator = new Calculator(Arrays.asList("2", "+", "3", "*"));

        // when then
        assertThatIllegalArgumentException().isThrownBy(calculator::calculate);
    }
}