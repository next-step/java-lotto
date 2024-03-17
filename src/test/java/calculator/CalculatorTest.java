package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @DisplayName("기본 연산자를 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"1 + 7:8", "9 - 3:6", "7 * 3:21", "9 / 2:4"}, delimiter = ':')
    void calculateWithBasicOperators(String input, int result) {
        // given
        calculator = new Calculator(input);

        // when
        int calculateResult = calculator.calculate();

        // then
        assertThat(calculateResult).isEqualTo(result);
    }

    @DisplayName("복합 연산자 메서드를 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"8 + 2 + 4 / 2 * 3:21", "9 / 2 / 2 * 3:6"}, delimiter = ':')
    void calculateWithMultiOperators(String input, int result) {
        // given
        calculator = new Calculator(input);

        // when
        int calculateResult = calculator.calculate();

        // then
        assertThat(calculateResult).isEqualTo(result);
    }
}
