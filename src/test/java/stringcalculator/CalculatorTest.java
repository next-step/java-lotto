package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

}
