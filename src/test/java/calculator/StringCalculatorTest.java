package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    private void 문자열_0_또는_null_Test() {
        assertThat(calculator.putNumberString("0")).isEqualTo(0);
        assertThat(calculator.putNumberString(null)).isEqualTo(0);
    }
}
