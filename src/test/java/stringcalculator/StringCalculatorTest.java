package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private static final StringCalculator STRING_CALCULATOR = new StringCalculator();

    @ParameterizedTest
    @CsvSource(value = {"2 + 3:5", "2 - 3:-1", "2 * 3:6", "4 / 2:2"}, delimiter = ':')
    void unaryEquationGiven_ReturnAnswer(String input, int answer) {
        assertThat(STRING_CALCULATOR.calculate(new Equation(input))).isEqualTo(answer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 / 3"})
    void remainderIsNotZeroGiven_ThrowException(String input) {
        assertThatThrownBy(() -> STRING_CALCULATOR.calculate(new Equation(input)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ExceptionMessage.DIVIDE_RESULT_SHOULD_BE_INTEGER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0 / 3", "3 / 0"})
    void numberIsZeroWhenDividingGiven_ThrowException(String input) {
        assertThatThrownBy(() -> STRING_CALCULATOR.calculate(new Equation(input)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ExceptionMessage.NUMBER_SHOULD_NOT_BE_ZERO_WHEN_DIVIDING.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 2 / 2:5", "2 * 0 * 2:0", "2 * 2 + 2 / 2 - 2:1"}, delimiter = ':')
    void equationsGiven_ReturnAnswer(String input, int answer) {
        assertThat(STRING_CALCULATOR.calculate(new Equation(input))).isEqualTo(answer);
    }
}
