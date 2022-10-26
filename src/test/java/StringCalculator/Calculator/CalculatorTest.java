package StringCalculator.Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1;1;2", "3;3;6", "0;4;4"}, delimiter = ';')
    public void addTest(int num1, int num2, int result) {
        assertThat(Calculator.add(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;1;0", "12;3;9", "0;4;-4"}, delimiter = ';')
    public void subtractTest(int num1, int num2, int result) {
        assertThat(Calculator.subtract(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;1;1", "4;3;12", "0;4;0"}, delimiter = ';')
    public void multiplyTest(int num1, int num2, int result) {
        assertThat(Calculator.multiply(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;1;1", "27;3;9", "0;4;0"}, delimiter = ';')
    public void divideTest(int num1, int num2, float result) {
        assertThat(Calculator.divide(num1, num2)).isEqualTo(result);
    }
}
