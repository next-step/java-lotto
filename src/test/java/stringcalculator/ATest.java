package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ATest {

    @Test
    void calculator_두숫자를더한다() {
        String firstNumber = "1";
        String secondNumber = "2";
        int expected = 3;

        Assertions.assertThat(Calculator.add(firstNumber, secondNumber)).isEqualTo(expected);
    }

    @Test
    void calculator_두숫자를뺀다() {
        String firstNumber = "1";
        String secondNumber = "2";
        int expected = -1;

        Assertions.assertThat(Calculator.minus(firstNumber, secondNumber)).isEqualTo(expected);
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
