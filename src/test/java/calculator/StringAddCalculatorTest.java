package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    public void whenNullOrEmptyString_thenZero() {
        int nullResult = StringAddCalculator.calculate(null);
        assertThat(nullResult).isEqualTo(0);
    }
}