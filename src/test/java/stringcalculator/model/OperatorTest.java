package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    void 한개의_사칙연산을_성공한다_덧셈() {
        int actual = Operator.SUM.calculate(2, 3);
        int expected = 5;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 한개의_사칙연산을_성공한다_뺄셈() {
        int actual = Operator.SUBTRACT.calculate(3, 2);
        int expected = 1;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 한개의_사칙연산을_성공한다_곱셈() {
        int actual = Operator.MULTIPLY.calculate(3, 2);
        int expected = 6;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 한개의_사칙연산을_성공한다_나눗셈() {
        int actual = Operator.DIVIDE.calculate(3, 2);
        int expected = 1;
        Assertions.assertThat(actual).isEqualTo(expected);
    }
    /*
        controller
        StringCalculatorController

        view
        InputView
        OutputView

        model
        Operand.enum.class
        Operator.class
        Processes.class

    * */
}
