package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorsTest {

    @DisplayName("사칙연산 계산을 한다.")
    @ParameterizedTest
    @CsvSource(value = {"3 + 2,5", "3 - 2,1", "3 * 2,6", "3 / 2,1"})
    void calculator(final String input, final String result) {

        final StringInput stringInput = new StringInput(input);
        final Expressions expressions = new Expressions(stringInput.split());
        final Operators operators = expressions.extract();

        assertThat(operators.finalOperate(expressions)).isEqualTo(result);
    }

    @DisplayName("2개 연산자 사칙연산 계산을 한다.")
    @ParameterizedTest
    @CsvSource(value = {"3 + 2 - 1,4", "3 - 2 * 5,5", "3 * 2 + 2,8", "3 / 2 - 1,0"})
    void two_calculator(final String input, final String result) {

        final StringInput stringInput = new StringInput(input);
        final Expressions expressions = new Expressions(stringInput.split());
        final Operators operators = expressions.extract();

        assertThat(operators.finalOperate(expressions)).isEqualTo(result);
    }
}
