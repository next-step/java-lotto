package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("문자열 계산기")
class StringCalculatorTest {

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} = {1}")
    @CsvSource(value = {"1 * 2 / 2 - 1=0", "1 + 1 * 7 / 2=7", "2 + 3 * 4 / 2=10"}, delimiter = '=')
    void 사칙연산_테스트(String input, int result) {

        StringCalculator stringCalculator = new StringCalculator(input);

        assertThat(stringCalculator.calculate()).isEqualTo(result);
    }
}