package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    void 덧셈이_가능하다() {
        assertThat(Operator.PLUS.executedResult(1, 1)).isEqualTo(2);
    }

    @Test
    void 뺄셈이_가능하다() {
        assertThat(Operator.MINUS.executedResult(1, 1)).isZero();
    }

    @Test
    void 곱셈이_가능하다() {
        assertThat(Operator.MULTIPLY.executedResult(1, 1)).isOne();
    }

    @Test
    void 나눗셈이_가능하다() {
        assertThat(Operator.DIVIDE.executedResult(1, 1)).isOne();
    }

    @MethodSource
    @ParameterizedTest
    void 문자열을통해_연산자를_찾을_수_있다(String arithmetic, Operator operator) {
        assertThat(Operator.foundOperator(arithmetic)).isEqualTo(operator);
    }

    private static Stream<Arguments> 문자열을통해_연산자를_찾을_수_있다() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINUS),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("/", Operator.DIVIDE)
        );
    }

}
