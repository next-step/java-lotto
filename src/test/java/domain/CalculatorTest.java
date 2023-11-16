package domain;

import domain.calculator.Calculator;
import domain.calculator.vo.OperatorEnum;
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
        calculator.getResult("1 + 2");

        assertThat(calculator.getNumbers().getNumberList())
                .extracting("value").containsExactly(1, 2);
        assertThat(calculator.getOperators().getOperatorList())
                .extracting("value").containsExactly(OperatorEnum.PLUS);
    }

    @DisplayName("Calculator 수식 계산 (더하기) 성공")
    @Test
    void calculator_sum_success() {
        Calculator calculator = new Calculator();
        int result = calculator.getResult("1 + 2");

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("Calculator 수식 계산 (빼기) 성공")
    @Test
    void calculator_subtract_success() {
        Calculator calculator = new Calculator();
        int result = calculator.getResult("1 - 2");

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("Calculator 수식 계산 (곱하기) 성공")
    @Test
    void calculator_multiply_success() {
        Calculator calculator = new Calculator();
        int result = calculator.getResult("1 * 2");

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("Calculator 수식 계산 (나누기) 성공")
    @Test
    void calculator_divide_success() {
        Calculator calculator = new Calculator();
        int result = calculator.getResult("2 / 2");

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("요구사항 입력값(2 + 3 * 4 / 2) 계산 성공")
    @Test
    void calculate_complex_success() {
        Calculator calculator = new Calculator();
        int result = calculator.getResult("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("소숫점 결과의 나눗셈은 정수 자리만 리턴한다.")
    @Test
    void calculate_divide_success() {
        Calculator calculator = new Calculator();
        int result = calculator.getResult("5 / 3");

        assertThat(result).isEqualTo(1);
    }
}
