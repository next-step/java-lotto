package arithmetic.operator;

import static arithmetic.operator.OperationFactory.*;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperationFactoryTest {
    @ParameterizedTest
    @MethodSource("expectedInstance")
    void getInstance(String operation, Operation expected) {
        assertThat(OperationFactory.getInstance(operation)).isEqualTo(expected);
    }

    @DisplayName(" +, -, *, / 이외의 연산자를 입력하면 예외를 발생시킨다")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "**", "a" })
    void getInstance_when_unknown_operation(String operation) {
        assertThatThrownBy(() -> {
            OperationFactory.getInstance(operation);
        }).isInstanceOf(UnsupportedOperationException.class).hasMessageMatching("Operator not supported.");
    }

    private static Stream<Arguments> expectedInstance() {
        return Stream.of(
                Arguments.arguments("+", ADDITION),
                Arguments.arguments("-", SUBTRACTION),
                Arguments.arguments("*", MULTIPLICATION),
                Arguments.arguments("/", DIVISION)
        );
    }
}
