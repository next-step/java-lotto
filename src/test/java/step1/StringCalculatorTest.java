package step1;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import step1.domain.Number;

class StringCalculatorTest {

    @ParameterizedTest(name = "계산 결과 확인 식: {0}")
    @MethodSource("provideCalculatorInput")
    void calculate(String expression, Number expected) {
        assertThat(new StringCalculator(expression).calculate()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCalculatorInput() {
        return Stream.of(
            Arguments.of("6 + 1 + 2 - 0 * 3 / 6", new Number(4)),
            Arguments.of("6 - 12 / 2", new Number(-3)),
            Arguments.of("1", new Number(1))
        );
    }
}
