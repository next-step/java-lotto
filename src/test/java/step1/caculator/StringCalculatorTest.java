package step1.caculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.calculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 / 0:0"}, delimiter = ':')
    void 주어진_문자열_연산식을_계산한다(String given, int expected) {
        StringCalculator cal = new StringCalculator();
        int actual = cal.evaluate(given);

        assertThat(actual).isEqualTo(expected);
    }
}
