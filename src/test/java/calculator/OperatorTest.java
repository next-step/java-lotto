package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Operator_bak.ERR_MSG_OPERATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"%", "^"})
    public void 사칙연산_기호가_아닌_경우(String s) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Operator_bak(s);
                }).withMessageMatching(ERR_MSG_OPERATOR);
    }

    @Test
    public void 덧셈() {
        assertThat(Operator.PLUS.operate(1, 2)).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        assertThat(Operator.MINUS.operate(5, 3)).isEqualTo(2);
    }

    @Test
    public void 곱셈() {
        assertThat(Operator.MULTIPLY.operate(5, 3)).isEqualTo(15);
    }

    @Test
    public void 나눗셈() {
        assertThat(Operator.DIVIDE.operate(6, 3)).isEqualTo(2);
    }

    @Test
    public void 나눗셈_정수리턴() {
        assertThat(Operator.DIVIDE.operate(7, 3)).isEqualTo(2);
    }
}