package calcurator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("null 또는 빈문자")
    void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(Const.INITIAL_NUMBER_ZERO);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSum_숫자하나(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        int expected = Integer.parseInt(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3","3,6=9"}, delimiter = '=')
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void splitAndSum_쉼표구분자(String input, int expectedCount) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expectedCount);
    }
}