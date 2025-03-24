package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    @ParameterizedTest
    @DisplayName("사칙연산 테스트")
    @MethodSource("provideOperatorTestCases")
    void testOperatorApply(Operator operator, int num1, int num2, int expected) {
        int result = operator.apply(num1, num2);

        assertEquals(expected, result);
    }

    static Stream<Arguments> provideOperatorTestCases() {
        return Stream.of(
                Arguments.of(Operator.ADD, 5, 3, 8),
                Arguments.of(Operator.ADD, -5, 3, -2),
                Arguments.of(Operator.ADD, 0, 0, 0),

                Arguments.of(Operator.SUBTRACT, 5, 3, 2),
                Arguments.of(Operator.SUBTRACT, 3, 5, -2),
                Arguments.of(Operator.SUBTRACT, -5, -3, -2),

                Arguments.of(Operator.MULTIPLY, 5, 3, 15),
                Arguments.of(Operator.MULTIPLY, -5, 3, -15),
                Arguments.of(Operator.MULTIPLY, 5, 0, 0),

                Arguments.of(Operator.DIVIDE, 6, 3, 2),
                Arguments.of(Operator.DIVIDE, 4, 2, 2),
                Arguments.of(Operator.DIVIDE, -6, 3, -2)
        );
    }

    @Test
    @DisplayName("0으로 나누면 예외가 발생한다")
    void divideByZeroShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Operator.DIVIDE.apply(10, 0));
    }

    @ParameterizedTest
    @DisplayName("연산자 기호를 입력받아 올바른 Operator를 반환한다")
    @MethodSource("provideSymbolToOperatorCases")
    void fromSymbolShouldReturnCorrectOperator(String symbol, Operator expected) {
        Operator operator = Operator.fromSymbol(symbol);

        assertEquals(expected, operator);
    }

    static Stream<Arguments> provideSymbolToOperatorCases() {
        return Stream.of(
                Arguments.of("+", Operator.ADD),
                Arguments.of("-", Operator.SUBTRACT),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("/", Operator.DIVIDE)
        );
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 기호를 입력하면 예외가 발생한다")
    @ValueSource(strings = {"", "^", "=", "x"})
    void invalidSymbolShouldThrowException(String symbol) {
        assertThrows(IllegalArgumentException.class, () -> Operator.fromSymbol(symbol));
    }

    @Test
    @DisplayName("각 연산자의 기호가 올바르게 반환되는지")
    void testGetSymbol() {
        assertEquals("+", Operator.ADD.getSymbol());
        assertEquals("-", Operator.SUBTRACT.getSymbol());
        assertEquals("*", Operator.MULTIPLY.getSymbol());
        assertEquals("/", Operator.DIVIDE.getSymbol());
    }
}
