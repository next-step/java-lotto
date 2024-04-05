package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.config.exception.DivideByZeroException;
import step1.domain.Numbers;
import step1.domain.Operator;

import static org.assertj.core.api.Assertions.*;
import static step1.config.message.ErrorMessage.DIVIDE_BY_ZERO_NOT_ALLOWED;

public class OperatorTest {


    @ParameterizedTest
    @ValueSource(strings = {"4 + 2"})
    public void 덧셈_결과_검증(String input) {
        Numbers numbers = new Numbers(input);
        int result = numbers.poll();

        assertThat(Operator.ADD.calculate(result,numbers.poll())).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 - 2"})
    public void 뺄셈_결과_검증(String input) {
        Numbers numbers = new Numbers(input);
        int result = numbers.poll();

        assertThat(Operator.SUBTRACT.calculate(result,numbers.poll())).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 * 2"})
    public void 곱셈_걸과_검증(String input) {
        Numbers numbers = new Numbers(input);
        int result = numbers.poll();

        assertThat(Operator.MULTIPLY.calculate(result,numbers.poll())).isEqualTo(8);

    }

    @ParameterizedTest
    @ValueSource(strings = {"6 / 3"})
    public void 나누셈_결과_검증(String input) {
        Numbers numbers = new Numbers(input);
        int result = numbers.poll();

        assertThat(Operator.DIVIDE.calculate(result,numbers.poll())).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"6 / 0"})
    public void 나누기_0_검증(String input) {
        Numbers numbers = new Numbers(input);
        int result = numbers.poll();

        assertThatThrownBy(() -> {
                    Operator.DIVIDE.calculate(result, numbers.poll());
                }).isInstanceOf(DivideByZeroException.class)
                .hasMessage(DIVIDE_BY_ZERO_NOT_ALLOWED.message());

    }

}
