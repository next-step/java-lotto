package stringcalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {
    @Test
    void 피연산자_문자를_저장한다() {
        Operand actual = new Operand("1");
        Operand expected = new Operand("1");
        Operand falseExpected = new Operand("2");

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isNotEqualTo(falseExpected);
    }

    @Test
    void 피연산자_숫자를_저장한다() {
        Operand actual = new Operand(1);
        Operand expected = new Operand(1);
        Operand falseExpected = new Operand(2);

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isNotEqualTo(falseExpected);
    }

    @Test
    void 피연산자는_숫자가_아니면_오류() {
        assertThatThrownBy(() -> {
            new Operand("k");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Operand.ONLY_ALLOWED_NUMBER);
    }

    @Test
    void 피연산자를_출력한다() {
        Operand operand = new Operand("1");
        int actual = operand.value();
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }
}
