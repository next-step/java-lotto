package stringcalculate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    private static Stream<Arguments> provideIntInput() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(6, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntInput")
    void Calculate(int a, int b) {
        assertAll(
                () -> assertEquals(Operator.calculate(a, "+", b), a + b),
                () -> assertEquals(Operator.calculate(a, "/", b), a / b),
                () -> assertEquals(Operator.calculate(a, "-", b), a - b),
                () -> assertEquals(Operator.calculate(a, "*", b), a * b)
        );
    }

}