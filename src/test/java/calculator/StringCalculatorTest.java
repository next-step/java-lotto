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
    void 문자열_0_또는_null_Test() {
        assertThat(calculator.isNullOrZero("0")).isTrue();
        assertThat(calculator.isNullOrZero(null)).isTrue();
    }
}
