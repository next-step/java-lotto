package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @DisplayName("덧셈 연산을 요청할 때, 덧셈 결과를 반환해야 한다.")
    @Test
    void calculate_givenPlus() {
        CalculatorRequest request = new CalculatorRequest(
                List.of(1, 2),
                List.of(ArithmeticOperator.PLUS)
        );
        assertThat(Calculator.calculate(request)).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 요청할 때, 뺄셈 결과를 반환해야 한다.")
    @Test
    void calculate_givenMinus() {
        CalculatorRequest request = new CalculatorRequest(
                List.of(1, 2),
                List.of(ArithmeticOperator.MINUS)
        );
        assertThat(Calculator.calculate(request)).isEqualTo(-1);
    }

    @DisplayName("곱셈 연산을 요청할 때, 곱셈 결과를 반환해야 한다.")
    @Test
    void calculate_givenMultiply() {
        CalculatorRequest request = new CalculatorRequest(
                List.of(1, 2),
                List.of(ArithmeticOperator.MULTIPLY)
        );
        assertThat(Calculator.calculate(request)).isEqualTo(2);
    }

    @DisplayName("나눗셈 연산을 요청할 때, 정수로 나누어 떨어지면 나눗셈 결과를 반환해야 한다.")
    @Test
    void calculate_givenDivideWhenDivisible() {
        CalculatorRequest request = new CalculatorRequest(
                List.of(4, 2),
                List.of(ArithmeticOperator.DIVIDE)
        );
        assertThat(Calculator.calculate(request)).isEqualTo(2);
    }

    @DisplayName("나눗셈 연산을 요청할 때, 0 으로 나누면 예외가 발생해야 한다.")
    @Test
    void calculate_givenDivideWithZero() {
        CalculatorRequest request = new CalculatorRequest(
                List.of(4, 0),
                List.of(ArithmeticOperator.DIVIDE)
        );
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(request));
    }

    @DisplayName("나눗셈 연산을 요청할 때, 정수로 나누어 떨어지지 않으면 예외가 발생해야 한다.")
    @Test
    void calculate_givenDivideWhenIndivisible() {
        CalculatorRequest request = new CalculatorRequest(
                List.of(4, 3),
                List.of(ArithmeticOperator.DIVIDE)
        );
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(request));
    }

    @DisplayName("올바른 형식의 문자열을 통해서 사칙연산을 요청할 때, 해당 사칙연산 결과를 반환해야 한다.")
    @Test
    void calculate_givenStringRequest() {
        assertThat(Calculator.calculate("2 + 3 * 4 / 2 - 1")).isEqualTo(9);
    }

}
