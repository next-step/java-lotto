package arithmetic.operator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {
    @ParameterizedTest
    @MethodSource("expectedInstance")
    void of(String operation, Operator expected) {
        assertThat(Operator.of(operation)).isEqualTo(expected);
    }

    @DisplayName(" +, -, *, / 이외의 연산자를 입력하면 예외를 발생시킨다")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "**", "a" })
    void of_when_unknown_operation(String operation) {
        assertThatThrownBy(() -> {
            Operator.of(operation);
        }).isInstanceOf(UnsupportedOperationException.class).hasMessageMatching("Operator not supported.");
    }

    private static Stream<Arguments> expectedInstance() {
        return Stream.of(
                Arguments.arguments("+", Operator.ADDITION),
                Arguments.arguments("-", Operator.SUBTRACTION),
                Arguments.arguments("*", Operator.MULTIPLICATION),
                Arguments.arguments("/", Operator.DIVISION)
        );
    }
}
