package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Calculator;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("덧셈")
    void add2() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("+",1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    void subtract() {
        Calculator stringCalculator = new Calculator();
        assertThat(stringCalculator.calculate("-",1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        Calculator stringCalculator = new Calculator();
        assertThat(stringCalculator.calculate("*",1,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        Calculator stringCalculator = new Calculator();
        assertThat(stringCalculator.calculate("/",1, 2)).isEqualTo(0);
    }
}
