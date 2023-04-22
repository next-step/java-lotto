package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 덧셈() {
        Calculator calculator = new Calculator();
        String expression = "2 + 3";
        int result = calculator.add(expression);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        Calculator calculator = new Calculator();
        String expression = "2 - 3";
        int result = calculator.substract(expression);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        Calculator calculator = new Calculator();
        String expression = "2 * 3";
        int result = calculator.multiply(expression);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        Calculator calculator = new Calculator();
        String expression = "10 / 2";
        int result = calculator.divide(expression);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 나눗셈_예외_처리() {
        Calculator calculator = new Calculator();
        String expression = "10 / 3";

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.divide(expression));
    }

    @Test
    void 입력값이_null일때_예외처리() {
        Calculator calculator = new Calculator();
        String expression = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.add(expression));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.substract(expression));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.multiply(expression));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.divide(expression));
    }

    @Test
    void 입력값이_blank일때_예외처리() {
        Calculator calculator = new Calculator();
        String expression = "     ";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.add(expression));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.substract(expression));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.multiply(expression));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.divide(expression));
    }

    @Test
    void 연산과_숫자_사이_공백이_없을경우_예외처리() {
        Calculator calculator = new Calculator();
        String expression = "2+3";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.add(expression));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.substract(expression));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.multiply(expression));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.divide(expression));
    }

    @Test
    void 사칙_연산을_모두_포함하는_기능구현() {
        Calculator calculator = new Calculator();
        String expression = "1 + 3 / 2 * 10 - 2 + 1 + 1";

        int result = calculator.calculate(expression);

        assertThat(result).isEqualTo(20);
    }
}
