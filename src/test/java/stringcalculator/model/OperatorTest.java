package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static stringcalculator.model.Operator.*;

public class OperatorTest {
    @Test
    void 한개의_사칙연산을_성공한다_덧셈() {
        int actual = SUM.calculate(2, 3);
        int expected = 5;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 한개의_사칙연산을_성공한다_뺄셈() {
        int actual = SUBTRACT.calculate(3, 2);
        int expected = 1;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 한개의_사칙연산을_성공한다_곱셈() {
        int actual = MULTIPLY.calculate(3, 2);
        int expected = 6;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 한개의_사칙연산을_성공한다_나눗셈() {
        int actual = DIVIDE.calculate(3, 2);
        int expected = 1;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 특수문자_4개를_연산자타입으로_바꿔준다() {
        Operator actualSum = convertStringToOperator("+");
        Operator actualSubtract = convertStringToOperator("-");
        Operator actualMultiply = convertStringToOperator("*");
        Operator actualDivide = convertStringToOperator("/");

        Assertions.assertThat(actualSum).isEqualTo(SUM);
        Assertions.assertThat(actualSubtract).isEqualTo(SUBTRACT);
        Assertions.assertThat(actualMultiply).isEqualTo(MULTIPLY);
        Assertions.assertThat(actualDivide).isEqualTo(DIVIDE);
    }

    @Test
    void 특수문자_4개_이외에_다른_값이_입력되면_오류() {
        Assertions.assertThatThrownBy(() -> {
                    convertStringToOperator("f");
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOWED_OPERATOR_ANOTHER_STRINGS);
    }
}