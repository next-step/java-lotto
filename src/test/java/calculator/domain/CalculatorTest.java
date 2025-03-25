package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 /", "  ", "2 2", "**"})
    @DisplayName("입력 문자열은 공백으로 나누었을 때, 숫자와 연산자가 반복되지 않으면 예외가 발생한다.")
    void validateInput(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 / 3", "3 / 2"})
    @DisplayName("입력 문자열의 나눗셈 결과가 정수가 아니면 예외가 발생한다.")
    void validateDivideNumber(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "-1", "0"})
    @DisplayName("연산자가 없고 단일 숫자이면, 단일 숫자를 반환한다.")
    void calculateOneNumber(String input) {
        long expected = Long.parseLong(input);
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"1 + 2,3", "1 - 2,-1", "1 * 2,2", "2 / 1,2"})
    @DisplayName("연산자가 하나있을 때, 연산 결과를 반환한다.")
    void calculateOneOperator(String input, long expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"1 + 2 + 1 * 3 / 2 - 1,5"})
    @DisplayName("연산자가 여러개있을 때, 연산 결과를 반환한다.")
    void calculateTwoOrMoreOperator(String input, long expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("연산 순서는 입력 값의 순서에 따라 결정된다.")
    void calculateOrder() {
        String input = "1 + 2 * 3";
        long expected = 9;
        long unExpected = 7;

        assertThat(calculator.calculate(input))
                .isEqualTo(expected)
                .isNotEqualTo(unExpected);
    }


}