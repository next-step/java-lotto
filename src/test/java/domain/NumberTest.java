package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.Calculator;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {

    @ParameterizedTest
    @DisplayName("null, empty")
    @MethodSource("nullEmptyParams")
    void parseErrorTest(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(input))
                .withMessage("Invalid number: " + input);
    }

    @ParameterizedTest
    @DisplayName("invalid input")
    @MethodSource("invalidInputParams")
    void parseErrorTest2(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(input))
                .withMessage("Invalid number: " + input);
    }

    @ParameterizedTest
    @DisplayName("parse success")
    @MethodSource("validInputParams")
    void parseSuccessTest(final String input, final int expected) {
        Assertions.assertThat(new Number(input).value())
                .isEqualTo(expected);
    }

    private static Stream<String> nullEmptyParams() {
        return Stream.of(
                (String) null,
                ""
        );
    }

    private static Stream<String> invalidInputParams() {
        return Stream.of(
                "1.1",
                "1,1",
                "1 1",
                "1a",
                "a1",
                "bsbd",
                "%*"
        );
    }

    private static Stream<Arguments> validInputParams() {
        return Stream.of(
                Arguments.arguments("1", 1),
                Arguments.arguments("1555", 1555),
                Arguments.arguments("999", 999),
                Arguments.arguments("-88821", -88821),
                Arguments.arguments("0", 0)
        );
    }
}