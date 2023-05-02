package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringCalculator.Operator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"+:6", "-:0", "*:9", "/:1"}, delimiter = ':')
    void 식계산(String key, int expected) {
        Operator operator = Operator.of(key);
        int number1 = 3;
        int number2 = 3;
        assertThat(operator.calculate(number1, number2)).isEqualTo(expected);
    }
}
