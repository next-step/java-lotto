package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    private static Stream<Arguments> makeCalculatorString() {
        return Stream.of(
                Arguments.of("3:4:5", ",|:", 3),
                Arguments.of("1&0&0&4", "&", 4),
                Arguments.of("4,4,4", "\\*", 1)
        );
    }

    @DisplayName("문자열 분리 테스트")
    @ParameterizedTest
    @MethodSource("makeCalculatorString")
    void split_test(String input, String delimiter, int expectedResult) {
        assertThat(StringSplitter.split(input, delimiter)).hasSize(expectedResult);
    }

}
