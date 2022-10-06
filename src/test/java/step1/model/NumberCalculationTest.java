package step1.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberCalculationTest {

    @ParameterizedTest
    @CsvSource(value = {"3:2:1", "3:3:0"}, delimiter = ':')
    public void 숫자_빼기_검증(int num1, int num2, int expected) {
        NumberCalculation calculation = new NumberCalculation(num1);
        calculation.subtract(num2);

        assertThat(calculation).isEqualTo(new NumberCalculation(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:2:5", "3:3:6"}, delimiter = ':')
    public void 숫자_더하기_검증(int num1, int num2, int expected) {
        NumberCalculation calculation = new NumberCalculation(num1);
        calculation.sum(num2);

        assertThat(calculation).isEqualTo(new NumberCalculation(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"2:2:1", "6:2:3"}, delimiter = ':')
    public void 숫자_나누기_검증(int num1, int num2, int expected) {
        NumberCalculation calculation = new NumberCalculation(num1);
        calculation.divided(num2);

        assertThat(calculation).isEqualTo(new NumberCalculation(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:2:6", "3:3:9"}, delimiter = ':')
    public void 숫자_곱하기_검증(int num1, int num2, int expected) {
        NumberCalculation calculation = new NumberCalculation(num1);
        calculation.multiply(num2);

        assertThat(calculation).isEqualTo(new NumberCalculation(expected));
    }
}