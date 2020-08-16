package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringaddcalculator.domain.StringAddCalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("콤마(,)로 구분된 숫자의 합")
    @CsvSource(value = {"1,2/3", "3,4/7"}, delimiter = '/')
    void splitAndSumCommas(String expression, int expected) {
        int result = StringAddCalculator.commaSum(expression);
        assertThat(result).isEqualTo(expected);
    }
}
