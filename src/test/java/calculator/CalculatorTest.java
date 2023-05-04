package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculatorTest_validation_입력값_null_공백() {
        String input = "";
        assertThatThrownBy(() ->Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculatorTest_validation_입력값_연산자_사칙연산기호확인() {
        String input = "2 ^ 3";
        assertThatThrownBy(() ->Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculatorTest_split_숫자와연산자() {
        String input = "2 + 3";
        input = input.replace(" ", "");
        assertThat(input.split(Calculator.NUMBER_PATTERN)[1]).isEqualTo("+");
        assertThat(input.split(Calculator.NUMBER_PATTERN).length).isEqualTo(2);
        assertThat(input.split(Calculator.OPERATOR_PATTERN)[0]).isEqualTo("2");
    }

    @Test
    void calculatorTest_getOperator() {
        assertThat(Operator.findOperator("+")).isEqualTo(Operator.PLUS);
    }

    @Test
    void calculatorTest_calculate() {
        String input = "2 + 3 * 4 / 2";
        assertThat(Calculator.calculate(input)).isEqualTo(10);
    }
}