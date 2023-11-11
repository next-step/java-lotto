package src;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2 - 1 * 5 / 5, 2",
            "5 + 7 - 2 * 5 / 5, 10"
    }, delimiter = ',')
    void 문자열_사칙연산을_수행할_수_있다(String value, int expectedValue) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.calculate(value);

        // then
        assertThat(result).isEqualTo(expectedValue);
    }
}
