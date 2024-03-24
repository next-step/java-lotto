package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.controller.StringCalculator;
import step1.domain.Numbers;
import step1.domain.Operator;
import step1.domain.Operators;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {


    @ParameterizedTest
    @ValueSource(strings = {"4 + 2"})
    public void 덧셈_결과_검증(String input) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(getResult(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 - 2"})
    public void 뺄셈_결과_검증(String input) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(getResult(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 * 2"})
    public void 곱셈_걸과_검증(String input) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(getResult(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"6 / 3"})
    public void 나누셈_결과_검증(String input) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(getResult(input));
    }

    private static int getResult(String input) {
        Numbers numbers = new Numbers(input);
        Operators operators = new Operators(input);
        Operator operator = operators.getOperators().get(0);
        return operator.calculate(numbers.getNumbers(0), numbers.getNumbers(1));
    }
}
