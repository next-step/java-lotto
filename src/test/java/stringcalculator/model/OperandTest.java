package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperandTest {
    @Test
    void 피연산자를_저장한다() {
        Operand actual = new Operand("1");
        Operand expected = new Operand("1");
        Operand falseExpected = new Operand("2");

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isNotEqualTo(falseExpected);
    }

    @Test
    void 피연산자는_숫자가_아니면_오류() {
        Assertions.assertThatThrownBy(() -> {
                    new Operand("k");
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Operand.ONLY_ALLOWED_NUMBER);
    }
}
