package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 입력 시 0 반환")
    void nullAndEmptyTest(String input) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3"})
    @DisplayName("숫자 1개 입력 시 해당 숫자 반환")
    void oneNumberTest(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "4,6|10"}, delimiter = '|')
    @DisplayName("쉼표(,)를 구분자로 문자열을 전달하면 숫자 합을 계산")
    void splitByCommaTest(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(expected);
    }

}
