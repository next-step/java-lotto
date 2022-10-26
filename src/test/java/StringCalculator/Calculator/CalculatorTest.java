package StringCalculator.Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1;1;2", "3;3;6", "0;4;4"}, delimiter = ';')
    public void addTest(float num1, float num2, float result) {
        assertThat(Calculator.add.apply(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;1;0", "12;3;9", "0;4;-4"}, delimiter = ';')
    public void subtractTest(float num1, float num2, float result) {
        assertThat(Calculator.subtract.apply(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;1;1", "4;3;12", "0;4;0"}, delimiter = ';')
    public void multiplyTest(float num1, float num2, int result) {
        assertThat(Calculator.multiply.apply(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;1;1", "27;3;9", "0;4;0", "1;4;0.25"}, delimiter = ';')
    public void divideTest(float num1, float num2, float result) {
        assertThat(Calculator.divide.apply(num1, num2)).isEqualTo(result);
    }
}
