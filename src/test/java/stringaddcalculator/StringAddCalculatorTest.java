package stringaddcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringaddcalculator.domain.StringAddCalculator;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("콜론(:) 및 콤마(,)로 구분된 숫자의 합")
    @CsvSource(value = {"3,4/7", "1:2/3", "1,2:3/6", "1:3,6/10"}, delimiter = '/')
    void splitAndSum(String expression, int expected) {
        int result = StringAddCalculator.sum(expression);
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
