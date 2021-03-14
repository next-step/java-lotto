package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource({"null, 0", "'', 0"})
    @DisplayName("빈 문자열 또는 null 값을 입력하는 경우 0을 반환한다.")
    void splitAndSum_Return0(String input, int result) {
        int calculationResult = new StringAddCalculator().splitAndSum(input);
        Assertions.assertThat(calculationResult).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSum_ReturnInput(String input) {
        int calculationResult = new StringAddCalculator().splitAndSum(input);
        Assertions.assertThat(calculationResult).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3"}, delimiter = ':')
    @DisplayName("숫자 두 개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void splitAndSum_ByComma(String input, int result) {
        int calculationResult = new StringAddCalculator().splitAndSum(input);
        Assertions.assertThat(calculationResult).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6"}, delimiter = '=')
    @DisplayName("컴마 이외에 콜론 구분자를 사용할 수 있다.")
    void splitAndSum_CommaAndColon(String input, int result) {
        int calculationResult = new StringAddCalculator().splitAndSum(input);
        Assertions.assertThat(calculationResult).isEqualTo(result);
    }

}
