package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class StringCalculatorTest {
    public static Stream<Arguments> generateNumData() {
        return Stream.of(
                Arguments.of("1 + 2 + 3", Arrays.asList(1, 2, 3)),
                Arguments.of("1 + 2 + 3 / 2", Arrays.asList(1, 2, 3, 2))
        );
    }

    public static Stream<Arguments> generateOperatorData() {
        return Stream.of(
                Arguments.of("1 + 2 + 3", Arrays.asList(" + ", " + ")),
                Arguments.of("1 + 2 + 3 / 2", Arrays.asList(" + ", " + ", " / ")),
                Arguments.of("1 + 2 * 3 / 3", Arrays.asList(" + ", " * ", " / "))
        );
    }

    @DisplayName("숫자 하나가 올 경우 그대로 리턴")
    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "0"})
    void 한개의_순자는_그대로_리턴(String input) {
        int actual = StringCalculator.calc(input);
        assertThat(actual).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("null이거나 빈 값이면 IllegalArgumentException 발생")
    @Test
    void IllegalArgumentException_테스트1() {
        assertThatThrownBy(() -> {
            int calc = StringCalculator.calc("");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            int calc = StringCalculator.calc(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 값으로 연산을 시도하면 IllegalArgumentException 발생")
    @Test
    void IllegalArgumentException_테스트2() {
        assertThatThrownBy(() -> {
            StringCalculator.operate(10, " & ", 20);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("나눗셈의 결과는 정수로 정한다")
    @ParameterizedTest
    @CsvSource(value = {
            "2 / 1, 2",
            "5 / 2, 2",
            "9 / 4, 2",
            "23 / 3, 7"
    })
    void 나눗셈의_결과는_정수다(String input, int result) {
        int actual = StringCalculator.calc(input);
        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("두 숫자 간의 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1, +, 2, 3",
            "2, +, 10, 12",
            "5, -, 4, 1",
            "100, -, 92, 8",
            "3, *, 4, 12",
            "1, *, 1, 1",
            "50, *, 3, 150",
            "8, /, 4, 2",
            "100, /, 3, 33",
            "100, /, 33, 3"
    })
    void 두_숫자_연산(int num1, String op, int num2, int result) {
        assertThat(StringCalculator.operate(num1, op, num2)).isEqualTo(result);
    }


    @DisplayName("input에 사칙연산이 들어있으면 계산해서 결과를 리턴한다")
    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3, 5",
            "1 + 2 + 3, 6",
            "3 - 1, 2",
            "2 * 10, 20",
            "2 + 3 * 4, 20",
            "2 + 3 * 4 / 2, 10"
    })
    void 사친연산_테스트(String input, int result) {
        int actual = StringCalculator.calc(input);
        assertThat(actual).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("generateNumData")
    void 숫자를_추출한다(String input, List<Integer> result) {
        List<Integer> integers = StringCalculator.extractNumbers(input);
        assertThat(integers).hasSize(result.size());
        assertThat(integers).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("generateOperatorData")
    void 사칙연산_기호_추출한다(String input, List<String> result) {
        List<String> operators = StringCalculator.extractOperators(input);
        assertThat(operators).hasSize(result.size());
        assertThat(operators).isEqualTo(result);
    }
}