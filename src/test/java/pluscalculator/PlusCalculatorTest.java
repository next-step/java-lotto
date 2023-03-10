package pluscalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pluscalculator.domain.Numbers;
import pluscalculator.domain.PlusCalculator;

public class PlusCalculatorTest {

    @ParameterizedTest
    @CsvSource({"'11,55,44', 110",
            "'1,2,3', 6"})
    @DisplayName("쉼표를 포함한 문자열을 분리해서 계산한다.")
    void commaSplit(String plusExpression, int expectValue) {

        Numbers numbers = PlusCalculator.extractNumbers(plusExpression);
        int sum = numbers.plusAll();

        Assertions.assertThat(sum).isEqualTo(expectValue);
    }
}
