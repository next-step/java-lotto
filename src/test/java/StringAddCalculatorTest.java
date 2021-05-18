import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @CsvSource(value = {"1:2,3|6", "4:3,2|9"}, delimiter = '|')
    @DisplayName("쉼표(,), 콜론(:)를 구분자로 문자열을 전달하면 숫자 합을 계산")
    void splitByColonAndCommaTest(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//'\n1'2'3"})
    @DisplayName("(//)와 (\\n) 문자 사이에 커스텀 구분자 지정")
    void splitByCustomDelimiterTest(String input) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-1,2", "-1,-2,-3"})
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생한다.")
    void splitNegativeTest(String input) {

        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}