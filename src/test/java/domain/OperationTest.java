package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OperationTest {
    @ParameterizedTest
    @DisplayName("parse operation +,-,*,/")
    @MethodSource("operationParams")
    void fromStringSuccess(final String operation, final Operation expected) {
        Assertions.assertThat(Operation.fromString(operation))
                .isNotNull()
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("parse error: invalid input")
    @MethodSource("invalidOperationParams")
    void fromStringInvalid(final String operation) {
        Assertions.assertThatThrownBy(() -> Operation.fromString(operation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid operator: " + operation);
    }

    private static Stream<Arguments> operationParams() {
        return Stream.of(
                Arguments.of("+", Operation.ADDITION),
                Arguments.of("-", Operation.SUBTRACTION),
                Arguments.of("*", Operation.MULTIPLICATION),
                Arguments.of("/", Operation.DIVISION)
        );
    }

    private static Stream<Arguments> invalidOperationParams() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of("invalid")
        );
    }
}
