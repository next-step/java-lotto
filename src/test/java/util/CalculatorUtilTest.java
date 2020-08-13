package util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorUtilTest {
    @ParameterizedTest
    @CsvSource({"10000,1000,10", "1000,0,0", "100,1000,0"})
    void divide(int inputNumber, int divideNumber, int expect) {
        int result = CalculatorUtil.divide(inputNumber, divideNumber);

        assertThat(result).isEqualTo(expect);
    }
}
