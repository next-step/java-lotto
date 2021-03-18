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
}
