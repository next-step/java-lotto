package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static calculator.domain.OperandTest.ONE;
import static calculator.domain.OperandTest.THREE;
import static calculator.domain.OperandTest.TWO;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {
    private static final Operator PLUS = new Operator("+");
    private static final Operator MINUS = new Operator("-");
    private static final Operator TIMES = new Operator("*");
    private static final Operator DIVISION = new Operator("/");

    private static Stream<String> invalidSigns() {
        return Stream.of("a", "1", " ", "", null);
    }

    @ParameterizedTest
    @MethodSource("invalidSigns")
    void Operator는_연산기호가_아닌_문자열로_생성시_예외를_발생시킨다(String sign) {
        assertThatThrownBy(() -> {
            new Operator(sign);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculate는_연산_결과를_반환한다() {
        assertAll(
                () -> assertEquals(PLUS.calculate(ONE, TWO), THREE),
                () -> assertEquals(MINUS.calculate(THREE, ONE), TWO),
                () -> assertEquals(TIMES.calculate(ONE, TWO), TWO),
                () -> assertEquals(DIVISION.calculate(TWO, ONE), TWO)
        );
    }
}
