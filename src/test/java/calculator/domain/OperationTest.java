package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static calculator.domain.Operation.findBySymbol;
import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @ParameterizedTest
    @MethodSource
    void 사칙연산(String operator, NumberValue result) {
        assertThat(findBySymbol(operator).apply(new NumberValue(2), new NumberValue(1))).isEqualTo(result);
    }

    static Stream<Arguments> 사칙연산() {
        return Stream.of(
                Arguments.arguments("+", new NumberValue(3)),
                Arguments.arguments("-", new NumberValue(1)),
                Arguments.arguments("*", new NumberValue(2)),
                Arguments.arguments("/", new NumberValue(2))
        );
    }

}
