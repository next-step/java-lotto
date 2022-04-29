package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2=10",
            "10 + 5 * 2 / 1=30",
            "1 - 1 * 0=0",
            "100 - 101 + 1 * 0 / 1=0"
    }, delimiter = '=')
    void calculate_문자열_계산하기(String text, int result) {
        assertThat(StringCalculator.calculate(text)).isEqualTo(result);
    }

}