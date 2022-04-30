package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperandTest {
    static final Operand ONE = new Operand(1);
    static final Operand TWO = new Operand(2);
    static final Operand THREE = new Operand(3);

    private static Stream<String> invalidOperands() {
        return Stream.of("a", "+", " ", "", null);
    }

    @Test
    void Operand는_숫자_문자열로_생성이_가능하다() {
        assertThat(new Operand("1"))
                .isInstanceOf(Operand.class);
    }

    @ParameterizedTest
    @MethodSource("invalidOperands")
    void Operand는_숫자가_아닌_문자열로_생성시_예외를_발생시킨다(String operand) {
        assertThatThrownBy(() -> {
            new Operand(operand);
        }).isInstanceOf(NumberFormatException.class);
    }
}
