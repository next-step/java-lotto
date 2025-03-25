package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @ValueSource(strings = {"1", "-1", "0"})
    @DisplayName("계산기 입력값이 단일 숫자이면, 단일 숫자를 반환한다.")
    void calculateOneNumber(String input) {
        long expected = Long.parseLong(input);
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

}