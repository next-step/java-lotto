package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @ValueSource(strings = {"1", "-1", "0"})
    @DisplayName("입력값이 단일 숫자이면, 단일 숫자를 반환한다.")
    void calculateOneNumber(String input) {
        long expected = Long.parseLong(input);
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"1 + 2,3", "1 - 2,-1", "1 * 2,2", "2 / 1,2"})
    @DisplayName("입력값에 연산자가 하나있을 때, 연산 결과를 반환한다.")
    void calculateOneOperator(String input, long expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"1 + 2 + 1 * 3 / 2 - 1,5"})
    @DisplayName("입력값에 연산자가 여러개있을 때, 연산 결과를 반환한다.")
    void calculateTwoOrMoreOperator(String input, long expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }



}