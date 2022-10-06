package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void calculator_두숫자를더한다() {
        Assertions.assertThat(Calculator.add("1", "2")).isEqualTo("3");
    }

    @Test
    void calculator_두숫자를뺀다() {
        Assertions.assertThat(Calculator.minus("1", "2")).isEqualTo("-1");
    }

    @Test
    void calculator_두숫자를곱한다() {
        Assertions.assertThat(Calculator.multiply("2", "3")).isEqualTo(6);
    }

    @Test
    void calculator_두숫자를나눈다() {
        Assertions.assertThat(Calculator.divide("4", "2")).isEqualTo(2);
    }
}
