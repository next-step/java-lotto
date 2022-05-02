package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("자연수 덧셈")
    void plus() {
        Calculator calculator = new Calculator();
        assertThat(calculator.plus("1", "3")).isEqualTo(4);
    }

    @Test
    @DisplayName("자연수 뺄셈")
    void mius() {
        Calculator calculator = new Calculator();
        assertThat(calculator.minus("3", "1")).isEqualTo(2);
        assertThat(calculator.minus("1", "3")).isEqualTo(-2);
    }

    @Test
    @DisplayName("자연수 곱셈")
    void multiply() {
        Calculator calculator = new Calculator();
        assertThat(calculator.multiply("3", "1")).isEqualTo(3);
        assertThat(calculator.multiply("1", "3")).isEqualTo(3);
    }

    @Test
    @DisplayName("자연수 나눗셈")
    void divide() {
        Calculator calculator = new Calculator();
        assertThat(calculator.divide("3", "1")).isEqualTo(3);
        assertThat(calculator.divide("1", "3")).isEqualTo(0);
    }

    @Test
    @DisplayName("연산자 인식")
    void calculatorByOperatorType() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculateOperatorType("+", "1", "2")).isEqualTo(3);
        assertThat(calculator.calculateOperatorType("-", "3", "1")).isEqualTo(2);
        assertThat(calculator.calculateOperatorType("*", "3", "1")).isEqualTo(3);
        assertThat(calculator.calculateOperatorType("/", "3", "1")).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("연산")
    @CsvSource(value = {"3 + 4 * 5 / 6:5", "3 + 4 * 5:35", "5 - 3 * 3 * 5 / 15:2", "10 - 5 - 3 / 2:1"}, delimiter = ':')
    void calculate(String input, int result) {
        Calculator calculator = new Calculator(input);
        assertThat(calculator.calculate()).isEqualTo(result);
    }

}
