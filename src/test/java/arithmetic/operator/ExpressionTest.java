package arithmetic.operator;

import static arithmetic.operator.Operator.*;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import arithmetic.exception.InvalidExpressionException;

class ExpressionTest {
    @DisplayName("수식에 입력된 숫자들을 리턴한다.")
    @ParameterizedTest
    @MethodSource("expectedNumbers")
    void numbers(String expression, Number... numbers) {
        assertThat(new Expression(expression).numbers()).containsExactly(numbers);
    }

    @DisplayName("유효하지 않은 수식이라면 InvalidExpressionException 예외를 발생시킨다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "1+", "2 + 3-"})
    void numbers_when_invalid_expression(String expression) {
        assertThatThrownBy(() -> {
            new Expression(expression).numbers();
        }).isInstanceOf(InvalidExpressionException.class).hasMessageMatching("Expression is invalid format.");
    }

    @DisplayName("수식에 입력된 연산자들을 리턴한다.")
    @ParameterizedTest
    @MethodSource("expectedOperations")
    void operations(String expression, Operation... operations) {
        assertThat(new Expression(expression).operations()).containsExactly(operations);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " "})
    void operations_when_invalid_expression(String expression) {
        assertThatThrownBy(() -> {
            new Expression(expression).operations();
        }).isInstanceOf(InvalidExpressionException.class).hasMessageMatching("Expression is invalid format.");
    }
    
    private static Stream<Arguments> expectedNumbers() {
        return Stream.of(
                Arguments.arguments("1+2", new Number[] { new Number(1), new Number(2) }),
                Arguments.arguments("6 - 7+1", new Number[] { new Number(6), new Number(7), new Number(1) }),
                Arguments.arguments("1+2*2/4", new Number[] { new Number(1), new Number(2), new Number(2), new Number(4) }),
                Arguments.arguments("2 + 3 * 4 / 2", new Number[] { new Number(2), new Number(3), new Number(4), new Number(2) })
        );
    }

    private static Stream<Arguments> expectedOperations() {
        return Stream.of(
                Arguments.arguments("1+2", new Operation[] { ADDITION.getOperation() }),
                Arguments.arguments("4 - 4*1", new Operation[] { SUBTRACTION.getOperation(), MULTIPLICATION.getOperation() }),
                Arguments.arguments("2 / 1 + 3*4", new Operation[] { DIVISION.getOperation(), ADDITION.getOperation(), MULTIPLICATION.getOperation() }),
                Arguments.arguments("1 +2 * 3*4/5", new Operation[] { ADDITION.getOperation(), MULTIPLICATION.getOperation(), MULTIPLICATION.getOperation(), DIVISION.getOperation() })
        );
    }
}
