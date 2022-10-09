package domain;

import calculator.domain.Operation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @ParameterizedTest
    @MethodSource
    void 사칙연산(String operator, int result) {
        assertThat(Operation.findBySymbol(operator).apply(2, 1)).isEqualTo(result);
    }

    static Stream<Arguments> 사칙연산() {
        return Stream.of(
                Arguments.arguments("+", 3),
                Arguments.arguments("-", 1),
                Arguments.arguments("*", 2),
                Arguments.arguments("/", 2)
        );
    }

}
