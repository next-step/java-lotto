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
        Numbers numbers = new Numbers(input);
        assertThat(Operator.ADD.calculate(numbers.getNumbers(0),numbers.getNumbers(1))).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 - 2"})
    public void 뺄셈_결과_검증(String input) {
        Numbers numbers = new Numbers(input);
        assertThat(Operator.SUBTRACT.calculate(numbers.getNumbers(0),numbers.getNumbers(1))).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 * 2"})
    public void 곱셈_걸과_검증(String input) {
        Numbers numbers = new Numbers(input);
        assertThat(Operator.MULTIPLY.calculate(numbers.getNumbers(0),numbers.getNumbers(1))).isEqualTo(8);

    }

    @ParameterizedTest
    @ValueSource(strings = {"6 / 3"})
    public void 나누셈_결과_검증(String input) {
        Numbers numbers = new Numbers(input);
        assertThat(Operator.DIVIDE.calculate(numbers.getNumbers(0),numbers.getNumbers(1))).isEqualTo(2);
    }

}
