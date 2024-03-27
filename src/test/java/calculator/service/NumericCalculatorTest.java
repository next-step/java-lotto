package calculator.service;

import calculator.code.MathSign;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumericCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "5,5,10"}, delimiter = ',')
    @DisplayName("덧셈 테스트")
    void sumTest(int numberA,
                 int numberB,
                 int expectedResult) {
        // When
        NumericCalculator numericCalculator = new NumericCalculator();
        int actual = numericCalculator.calculate(numberA, numberB, MathSign.PLUS);

        // Then
        assertThat(actual).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,1,1", "4,5,-1"}, delimiter = ',')
    @DisplayName("뺄셈 테스트")
    void differenceTest(int numberA,
                        int numberB,
                        int expectedResult) {
        // When
        NumericCalculator numericCalculator = new NumericCalculator();
        int actual = numericCalculator.calculate(numberA, numberB, MathSign.MINUS);

        // Then
        assertThat(actual).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,1", "9,0,0"}, delimiter = ',')
    @DisplayName("곱셈 테스트")
    void productTest(int numberA,
                     int numberB,
                     int expectedResult) {
        // When
        NumericCalculator numericCalculator = new NumericCalculator();
        int actual = numericCalculator.calculate(numberA, numberB, MathSign.MULTIPLY);

        // Then
        assertThat(actual).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,2,2", "9,2,4"}, delimiter = ',')
    @DisplayName("나눗셈 테스")
    void quotientTest(int numberA,
                      int numberB,
                      int expectedResult) {
        // When
        NumericCalculator numericCalculator = new NumericCalculator();
        int actual = numericCalculator.calculate(numberA, numberB, MathSign.DIVIDE);

        // Then
        assertThat(actual).isEqualTo(expectedResult);
    }

}
