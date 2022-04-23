package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3:5", "2 - 3:-1", "2 * 3:6", "4 / 2:2"}, delimiter = ':')
    void unaryEquationGiven_ReturnAnswer(String input, int answer) {
        assertThat(new StringCalculator().calculate(new Equation(input))).isEqualTo(answer);
    }

    @Test
    void remainderIsNotZeroGiven_ThrowException() {
        assertThatThrownBy(() -> new StringCalculator().calculate(new Equation("2 / 3")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ExceptionMessage.DIVIDE_RESULT_SHOULD_BE_INTEGER.getMessage());
    }
}
