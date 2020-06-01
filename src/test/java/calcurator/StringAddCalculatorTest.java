package calcurator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}