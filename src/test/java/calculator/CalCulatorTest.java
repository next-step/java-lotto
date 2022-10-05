package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Calculator.ERR_INPUT_ARG;
import static org.assertj.core.api.Assertions.*;

public class CalCulatorTest {

    private Calculator cal = new Calculator();

    @Test
    public void 계산() {
        assertThat(cal.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
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
