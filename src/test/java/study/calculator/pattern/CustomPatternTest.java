package study.calculator.pattern;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.calculator.exception.CalculatorException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CustomPatternTest {

    private static Stream<Arguments> customEntry() {
        return Stream.of(
                Arguments.of("//;\n3;4;5", new String[]{"3", "4", "5"}),
                Arguments.of("//#\n7#8#9", new String[]{"7", "8", "9"}),
                Arguments.of("//@\n7@8@9", new String[]{"7", "8", "9"})
        );
    }

    private static Stream<Arguments> invalidStringEntry() {
        return Stream.of(
                Arguments.of("//"),
                Arguments.of("\n"),
                Arguments.of("??")
        );
    }

    @ParameterizedTest(name = "{0} 문자열을 기본 구분자로 분리한 결과 값 {1}")
    @MethodSource(value = "customEntry")
    void matches_custom_문자열분리(String given, String[] expected) {
        // given
        CustomPattern customPattern = new CustomPattern();
        // when
        String[] matches = customPattern.matches(given);
        // then
        assertThat(matches).containsExactly(expected);
    }
    @ParameterizedTest(name = "입력 된 문자열이 정규식에 부합하지 않은 경우 예외 테스트")
    @MethodSource(value = "invalidStringEntry")
    void testCase(String given) {
        CustomPattern customPattern = new CustomPattern();
        // when
        assertThatExceptionOfType(CalculatorException.class)
                .isThrownBy(() -> {
                    customPattern.matches(given);
                });
    }
}
