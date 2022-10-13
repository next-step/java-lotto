package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {
    public static Stream<Arguments> provideOperatorSign() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.SUBTRACT),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("/", Operator.DIVIDE)
        );
    }

    public static Stream<Arguments> provideOperatorSignAndCalculateResult() {
        return Stream.of(
                Arguments.of(Operator.PLUS, new Number(6)),
                Arguments.of(Operator.SUBTRACT, new Number(2)),
                Arguments.of(Operator.MULTIPLY, new Number(8)),
                Arguments.of(Operator.DIVIDE, new Number(2))
        );
    }

    @ParameterizedTest
    @MethodSource("provideOperatorSign")
    void operator_sign(String sign, Operator operator) {
        assertThat(Operator.of(sign)).isEqualTo(operator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "(", "a"})
    void not_operator_sign(String sign) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.of(sign))
                .withMessage("잘못된 연산자 입니다.");
    }

    @ParameterizedTest
    @MethodSource("provideOperatorSignAndCalculateResult")
    void calculate_by_operator(Operator operator, Number result) {
        assertThat(operator.calculate(new Number(4), new Number(2))).isEqualTo(result);
    }
}
