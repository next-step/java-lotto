package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("사칙연산 결과 테스트")
    @CsvSource(value = {"2 + 3 * 4 / 2,10", "2 + 3 * 4 - 4,16"}, delimiter = ',')
    void testFourOperation(String input, int expected) {
        StringCalculator stringCalculator = new StringCalculator();

        assertThat(stringCalculator.calculate(input)).isEqualTo(expected);
    }
}
