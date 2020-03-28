package stringPlusCalculate.Domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3:6", ":0", "1,2:3", "1,2,3:6", "1,2:3:6"}, delimiter = ':')
    void calculatorTest(String input, String expected) {
        Calculator calculator = Calculator.init();

        Double result = calculator.calculate(input, Operator.PLUS);

        assertThat(result).isEqualTo(Double.parseDouble(expected));
    }
}
