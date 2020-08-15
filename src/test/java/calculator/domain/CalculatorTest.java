package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    private static Stream<Arguments> makeCalculatorString() {
        return Stream.of(
                Arguments.of("3:5:11", 19),
                Arguments.of("5:0,7", 12),
                Arguments.of("//;\n1;1;1;1;1", 5),
                Arguments.of("3", 3)
        );
    }

    @DisplayName("calculate 테스트")
    @ParameterizedTest
    @MethodSource("makeCalculatorString")
    void calculate(String input, int expectedResult) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> makeCalculatorStringWithMetaCharacter() {
        return Stream.of(
                Arguments.of("//+\n3+5+11+1+6+13", 39),
                Arguments.of("//{\n5{0{7", 12),
                Arguments.of("//*\n1*1*1*1*1", 5),
                Arguments.of("//^\n9^9", 18),
                Arguments.of("//|\n9|9", 18)
        );
    }

    @DisplayName("calculate 테스트 - split Meta Character가 delimiters인 경우")
    @ParameterizedTest
    @MethodSource("makeCalculatorStringWithMetaCharacter")
    void calculate_with_meta_character(String input, int expectedResult) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult);

    }

    @ParameterizedTest
    @CsvSource(value = {"1^1:\\^", "1*1:\\*", "1$1:\\$", "1+1:\\+", "1{1:\\{", "1)1:\\)", "1.1:\\.", "1?1:\\?"}
            , delimiter = ':')
    void meta_character_test(String input, String symbol) {
        // ^, *, $, +, {, }, (, ), [, ], ., ?
        List<String> actual = Arrays.asList(input.split(symbol));

        assertThat(actual).containsExactly("1", "1");
    }
}
