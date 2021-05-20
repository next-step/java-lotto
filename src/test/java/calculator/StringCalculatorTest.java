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

    @Test
    void 문자열에_커스텀구분자_적용_Test() {
        calculator.putNumberString("//;\n1;2;3");
        assertThat(calculator.delimiter()).isEqualTo(";");
    }
}
