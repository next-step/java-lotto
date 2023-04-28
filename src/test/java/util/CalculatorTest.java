package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @ParameterizedTest
    @DisplayName("parse error: null, empty")
    @MethodSource("nullEmptyParams")
    void parseErrorTest(final String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Calculator.calculate(input));
    }

    @ParameterizedTest
    @DisplayName("parse error: invalid input")
    @MethodSource("invalidInputParams")
    void parseErrorTest2(final String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Calculator.calculate(input))
            .withMessage("Invalid expression: " + input);
    }

    @ParameterizedTest
    @DisplayName("add, subtract, multiply, divide")
    @MethodSource("operationParams")
    void parseSuccessTest(final String input, final int expected) {
        Assertions.assertThat(Calculator.calculate(input))
            .isEqualTo(expected);
    }

    private static Stream<Arguments> nullEmptyParams() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of("")
        );
    }

    private static Stream<Arguments> invalidInputParams() {
        return Stream.of(
                Arguments.of("1 +"),
                Arguments.of("1 + 2 +"),
                Arguments.of("1 + 2 + 3 -")
        );
    }

    private static Stream<Arguments> operationParams() {
        return Stream.of(
                Arguments.of("1 + 2", 3),
                Arguments.of("1 - 2", -1),
                Arguments.of("1 * 2", 2),
                Arguments.of("3 / 2", 1),
                Arguments.of("2 + 3 * 4 / 2", 10)
        );
    }
}
