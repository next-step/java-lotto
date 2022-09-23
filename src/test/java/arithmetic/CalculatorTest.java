package arithmetic;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import arithmetic.operator.Expression;
import arithmetic.operator.Number;

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("expressions")
    void calculate(Expression expression, Number expected) {
        assertThat(new Calculator().calculate(expression)).isEqualTo(expected);
    }
    
    private static final Stream<Arguments> expressions() {
        return Stream.of(
                Arguments.arguments(new Expression("1+2"), new Number(3)),
                Arguments.arguments(new Expression("2+3*4/2"), new Number(10)),
                Arguments.arguments(new Expression("6+3*4/2-1"), new Number(17)),
                Arguments.arguments(new Expression("3/2"), new Number(1))
        );
    }
}
