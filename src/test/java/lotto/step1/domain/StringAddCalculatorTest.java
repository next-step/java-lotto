package lotto.step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("null 또는 빈문자")
    @ParameterizedTest
    @MethodSource("provideNullOREmpty")
    public void splitAndSum_null_또는_빈문자(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNullOREmpty() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("", 0)
        );
    }

    @DisplayName("문자열 결과 테스트")
    @ParameterizedTest
    @MethodSource("provideCorrectString")
    public void splitAndSum(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCorrectString() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("3,4,5", 12),
                Arguments.of("5,7:1", 13),
                Arguments.of("//!\n10!2!7", 19)
        );
    }
}
