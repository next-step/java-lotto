package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"'3 + 2':5", "'3 - 2':1", "'3 * 2':6", "'3 / 2':1", "'2 + 3 * 4 / 2':10"}, delimiter = ':')
    @DisplayName("사칙연산 테스트")
    void calculatorTest(String string, int number) {
        InputString text = new InputString(string);
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.stringCalculator(text);

        assertThat(result).isEqualTo(number);
    }

}
