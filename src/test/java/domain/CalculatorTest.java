package domain;

import domain.calculator.Calculator;
import domain.calculator.vo.OperatorEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertThat(calculator.getOperators().getOperatorList()).containsExactly(OperatorEnum.PLUS);
    }

    @DisplayName("Calculator 수식 계산 성공")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 - 2:-1", "1 * 2:2", "2 / 2:1"}, delimiter = ':')
    void calculator_calculate_success(String input, String expected) {
        Calculator calculator = new Calculator();
        int result = calculator.getResult(input);
        assertThat(result).isEqualTo(Integer.valueOf(expected));
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
