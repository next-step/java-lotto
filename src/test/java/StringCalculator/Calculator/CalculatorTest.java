package StringCalculator.Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1;1;2", "3;3;6", "0;4;4"}, delimiter = ';')
    @DisplayName("두 실수 더하기")
    public void addTest(final float num1, final float num2, final float result) {
        assertThat(Calculator.add.apply(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;1;0", "12;3;9", "0;4;-4"}, delimiter = ';')
    @DisplayName("두 실수 빼기")
    public void subtractTest(final float num1, final float num2, final float result) {
        assertThat(Calculator.subtract.apply(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;1;1", "4;3;12", "0;4;0"}, delimiter = ';')
    @DisplayName("두 실수 곱하기")
    public void multiplyTest(final float num1, final float num2, final int result) {
        assertThat(Calculator.multiply.apply(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;1;1", "27;3;9", "0;4;0", "1;4;0.25"}, delimiter = ';')
    @DisplayName("두 실수 나누기")
    public void divideTest(final float num1, final float num2, final float result) {
        assertThat(Calculator.divide.apply(num1, num2)).isEqualTo(result);
    }
}
