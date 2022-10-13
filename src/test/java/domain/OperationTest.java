package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static calculator.domain.Operation.DIVIDE;
import static calculator.domain.Operation.findBySymbol;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationTest {

    @ParameterizedTest
    @MethodSource
    void 사칙연산(String operator, int result) {
        assertThat(findBySymbol(operator).apply(2, 1)).isEqualTo(result);
    }

    static Stream<Arguments> 사칙연산() {
        return Stream.of(
                Arguments.arguments("+", 3),
                Arguments.arguments("-", 1),
                Arguments.arguments("*", 2),
                Arguments.arguments("/", 2)
        );
    }

    @Test
    void 영으로_나누기_예외() {
        assertThatThrownBy(() -> DIVIDE.apply(1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
