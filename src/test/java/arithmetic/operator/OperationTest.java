package arithmetic.operator;

import static arithmetic.operator.Division.*;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperationTest {
    @ParameterizedTest
    @MethodSource("additionNumbers")
    void addition(Number number1, Number number2, Number expected) {
        assertThat(new Addition().compute(number1, number2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("subtractionNumbers")
    void subtraction(Number number1, Number number2, Number expected) {
        assertThat(new Subtraction().compute(number1, number2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("multiplicationNumbers")
    void multiplication(Number number1, Number number2, Number expected) {
        assertThat(new Multiplication().compute(number1, number2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("divisionNumbers")
    void divide(Number number1, Number number2, Number expected) {
        assertThat(new Division().compute(number1, number2)).isEqualTo(expected);
    }

    @DisplayName("0 으로 나누려고 하면 UnsupportedOperationException 예외를 발생시킨다.")
    @Test
    void divide_when_zero() {
        assertThatThrownBy(() -> {
            new Division().compute(new Number(10), ZERO);
        }).isInstanceOf(UnsupportedOperationException.class).hasMessageMatching("Cannot be divided into zero.");
    }

    private static Stream<Arguments> additionNumbers() {
        return Stream.of(
                Arguments.arguments(new Number(2), new Number(3), new Number(5)),
                Arguments.arguments(new Number(0), new Number(2), new Number(2)),
                Arguments.arguments(new Number(1), new Number(-1), new Number(0))
        );
    }

    private static Stream<Arguments> subtractionNumbers() {
        return Stream.of(
                Arguments.arguments(new Number(2), new Number(1), new Number(1)),
                Arguments.arguments(new Number(1), new Number(2), new Number(-1)),
                Arguments.arguments(new Number(1), new Number(0), new Number(1))
        );
    }

    private static Stream<Arguments> multiplicationNumbers() {
        return Stream.of(
                Arguments.arguments(new Number(3), new Number(0), new Number(0)),
                Arguments.arguments(new Number(2), new Number(-1), new Number(-2)),
                Arguments.arguments(new Number(3), new Number(3), new Number(9)),
                Arguments.arguments(new Number(2), new Number(1), new Number(2))
        );
    }

    private static Stream<Arguments> divisionNumbers() {
        return Stream.of(
                Arguments.arguments(new Number(0), new Number(3), new Number(0)),
                Arguments.arguments(new Number(2), new Number(-1), new Number(-2)),
                Arguments.arguments(new Number(9), new Number(3), new Number(3)),
                Arguments.arguments(new Number(1), new Number(1), new Number(1))
        );
    }
}
