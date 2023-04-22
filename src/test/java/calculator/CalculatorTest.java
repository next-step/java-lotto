package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 덧셈() {
        String expression = "2 + 3";
        Calculator calculator = new Calculator(expression);
        int result = calculator.add();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        String expression = "2 - 3";
        Calculator calculator = new Calculator(expression);

        int result = calculator.substract();

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        String expression = "2 * 3";
        Calculator calculator = new Calculator(expression);

        int result = calculator.multiply();

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        String expression = "10 / 2";
        Calculator calculator = new Calculator(expression);

        int result = calculator.divide();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 나눗셈_예외_처리() {
        String expression = "10 / 3";
        Calculator calculator = new Calculator(expression);

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(calculator::divide);
    }



    @Test
    void 사칙_연산을_모두_포함하는_기능구현() {
        String expression = "1 + 3 / 2 * 10 - 2 + 1 + 1";
        Calculator calculator = new Calculator(expression);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(20);
    }
}
