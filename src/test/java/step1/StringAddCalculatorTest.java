package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("Null 또는 빈 문자열을 입력하면 0을 반환한다")
    @NullAndEmptySource
    @ParameterizedTest
    void splitAndSum_NullAndEmpty_Zero(String formula) {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력하면 해당 숫자를 반환한다")
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @ParameterizedTest
    void splitAndSum_SingleNumber_ConvertToInt(String formula) {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(Integer.parseInt(formula));
    }
}
