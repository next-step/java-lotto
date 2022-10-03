package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Calculator.ERR_INPUT_ARG;
import static calculator.Operator.ERR_MSG_OPERATOR;
import static org.assertj.core.api.Assertions.*;

public class CalCulatorTest {

    private Calculator cal = new Calculator();

    @Test
    public void 계산() {
        assertThat(cal.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    public void 덧셈() {
        assertThat(cal.plus(1, 2)).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        assertThat(cal.minus(5, 3)).isEqualTo(2);
    }

    @Test
    public void 곱셈() {
        assertThat(cal.multiply(5, 3)).isEqualTo(15);
    }

    @Test
    public void 나눗셈() {
        assertThat(cal.divide(6, 3)).isEqualTo(2);
    }

    @Test
    public void 나눗셈_정수리턴() {
        assertThat(cal.divide(7, 3)).isEqualTo(2);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "   "})
    public void 입력값_null_공백(String s) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    cal.calculate(s);
                }).withMessageMatching(ERR_INPUT_ARG);
    }


}
