package domain;

import domain.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("Calculator 객체 생성 성공")
    @Test
    void calculator_init_success() {
        Calculator calculator = new Calculator();

        assertThat(calculator).isNotNull();
    }

    @DisplayName("Calculator 수식 입력 성공")
    @Test
    void calculator_register_input_success() {
        Calculator calculator = new Calculator();
        calculator.doCalculate("1 + 2");

        assertThat(calculator.getInput()).isEqualTo("1 + 2");
    }

    @DisplayName("Calculator 수식 계산 (더하기) 성공")
    @Test
    void calculator_sum_success() {
        Calculator calculator = new Calculator();
        int result = calculator.doCalculate("1 + 2");

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("Calculator 수식 계산 (빼기) 성공")
    @Test
    void calculator_subtract_success() {
        Calculator calculator = new Calculator();
        int result = calculator.doCalculate("1 - 2");

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("Calculator 수식 계산 (곱하기) 성공")
    @Test
    void calculator_multiply_success() {
        Calculator calculator = new Calculator();
        int result = calculator.doCalculate("1 * 2");

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("Calculator 수식 계산 (나누기) 성공")
    @Test
    void calculator_divide_success() {
        Calculator calculator = new Calculator();
        int result = calculator.doCalculate("2 / 2");

        assertThat(result).isEqualTo(1);
    }
}
