package calc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @Test
    void 빈문자열_null_입력시_0을_반환테스트() {
        assertThat(calculator.add(null)).isEqualTo(0);
        assertThat(calculator.add("")).isEqualTo(0);
    }
}
