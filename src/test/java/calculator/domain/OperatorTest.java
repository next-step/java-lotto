package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
    @ParameterizedTest(name = "{displayName} {0}=={1}")
    @CsvSource(value = {"+:ADD", "-:SUBTRACT", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    @DisplayName("Operator 생성 테스트")
    void operator(String input, Operator expected) {
        // when
        Operator actual = Operator.of(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} {0}+{1}={2}")
    @CsvSource(value = {"1:2:3", "-1:0:-1", "0:0:0"}, delimiter = ':')
    @DisplayName("덧셈 테스트")
    void add(int a, int b, int expected) {
        // given
        Operator operator = Operator.ADD;

        // when
        int actual = operator.operate(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} {0}-{1}={2}")
    @CsvSource(value = {"1:2:-1", "2:1:1", "0:0:0"}, delimiter = ':')
    @DisplayName("뺄셈 테스트")
    void subtract(int a, int b, int expected) {
        // given
        Operator operator = Operator.SUBTRACT;

        // when
        int actual = operator.operate(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} {0}*{1}={2}")
    @CsvSource(value = {"1:2:2", "-2:-1:2", "2:0:0", "7:-1:-7"}, delimiter = ':')
    @DisplayName("곱셈 테스트")
    void multiply(int a, int b, int expected) {
        // given
        Operator operator = Operator.MULTIPLY;

        // when
        int actual = operator.operate(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} {0}/{1}={2}")
    @CsvSource(value = {"2:2:1", "-10:5:-2", "-20:-4:5", "0:2:0"}, delimiter = ':')
    @DisplayName("나눗셈 테스트")
    void divide(int a, int b, int expected) {
        // given
        Operator operator = Operator.DIVIDE;

        // when
        int actual = operator.operate(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Operator 생성 테스트 (예외)")
    void operatorException() {
        // given
        String input = "x";

        // then
        assertThatThrownBy(() -> Operator.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다.");
    }
}
