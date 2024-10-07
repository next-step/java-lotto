package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticOperatorTest {

    @ParameterizedTest
    @MethodSource("사칙연산_테스트_케이스")
    void create(ArithmeticOperator operator, int firstNumber, int secondNumber, int expected) {
        assertEquals(expected, operator.calculate(firstNumber, secondNumber));
    }

    private static Stream<Arguments> 사칙연산_테스트_케이스() {
        return Stream.of(
                Arguments.of(ArithmeticOperator.PLUS, 5, 3, 8),
                Arguments.of(ArithmeticOperator.MINUS, 5, 3, 2),
                Arguments.of(ArithmeticOperator.MULTIPLY, 5, 3, 15),
                Arguments.of(ArithmeticOperator.DIVIDE, 6, 3, 2)
        );
    }

    @DisplayName("잘못된 연산자이면 예외가 발생한다.")
    @Test
    void throwExceptionForInvalidOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ArithmeticOperator.from("&");
        });
    }
}
