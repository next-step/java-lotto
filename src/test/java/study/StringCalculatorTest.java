package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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

    @DisplayName("input에 +가 있다면 덧셈 결과를 리턴한다")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3, 5", "1 + 1, 2", "1 + 2 + 3, 6"})
    void 단순한_덧셈_테스트(String input, int result) {
        int actual = StringCalculator.calc(input);
        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("input에 -가 있다면 뺄셈 결과를 리턴한다")
    @ParameterizedTest
    @CsvSource(value = {"3 - 1, 2"})
    void 단순한_뺄셈_테스트(String input, int result) {
        int actual = StringCalculator.calc(input);
        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("input에 사칙연산이 들어있으면 계산해서 결과를 리턴한다")
    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3, 5",
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