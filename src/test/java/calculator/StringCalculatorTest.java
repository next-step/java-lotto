package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생한다.")
    void throwExceptionWhenInputIsNullOrEmpty(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값에 null 또는 공백만 존재하여 계산을 할 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 2 + 3:6", "1 + 2 + 3 + 4:10"}, delimiter = ':')
    @DisplayName("입력값이 덧셈 연산으로만 이루어졌을 때 calculate 메서드가 덧셈을 수행한다.")
    void sumTest(String input, int expected) {
        assertThat(StringCalculator.calculate(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "100 - 100 - 100:-100", "-1 - -2 - -3 - -4:8"}, delimiter = ':')
    @DisplayName("입력값이 뺄셈 연산으로만 이루어졌을 때 calculate 메서드가 뺄셈을 수행한다.")
    void subtractionTest(String input, int expected) {
        assertThat(StringCalculator.calculate(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 2:2", "2 * 2 * 3: 12", "-1 * -2 * -3:-6"}, delimiter = ':')
    @DisplayName("입력값이 곱셈 연산으로만 이루어졌을 때 calculate 메서드가 곱셈을 수행한다.")
    void multiplicationTest(String input, int expected) {
        assertThat(StringCalculator.calculate(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 / 2:2", "6 / 3 / 2: 1", "100 / 5 / 5 / 4:1"}, delimiter = ':')
    @DisplayName("입력값이 나눗셈 연산으로만 이루어졌을 때 calculate 메서드가 나눗셈을 수행한다.")
    void divisionTest(String input, int expected) {
        assertThat(StringCalculator.calculate(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 4 / 2:3", "2 + 3 * 4 / 2:10"}, delimiter = ':')
    @DisplayName("calculate 메서드가 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산을 수행한다.")
    void priorityTest(String input, int expected) {
        assertThat(StringCalculator.calculate(input))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값이 나눗셈 연산으로만 이루어졌을 때 calculate 메서드가 나머지 연산을 수행한다.")
    void remainTest() {
        assertThat(StringCalculator.calculate("3 % 2"))
                .isEqualTo(3 % 2);
    }
}
