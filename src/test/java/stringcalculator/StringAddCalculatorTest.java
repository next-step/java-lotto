package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource({", 0", "'', 0"})
    @DisplayName("빈 문자열 또는 null 값을 입력하는 경우 0을 반환한다.")
    void splitAndSum_Return0(String input, int result) {
        int calculationResult = new StringAddCalculator().splitAndSum(input);
        assertThat(calculationResult).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSum_ReturnInput(String input) throws Exception {
        int calculationResult = new StringAddCalculator().splitAndSum(input);
        assertThat(calculationResult).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3"}, delimiter = ':')
    @DisplayName("숫자 두 개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void splitAndSum_ByComma(String input, int result) throws Exception {
        int calculationResult = new StringAddCalculator().splitAndSum(input);
        assertThat(calculationResult).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6"}, delimiter = '=')
    @DisplayName("컴마 이외에 콜론 구분자를 사용할 수 있다.")
    void splitAndSum_CommaAndColon(String input, int result) throws Exception {
        int calculationResult = new StringAddCalculator().splitAndSum(input);
        assertThat(calculationResult).isEqualTo(result);
    }

    @Test
    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void splitAndSum_CustomSeparator() throws Exception {
        String input = "//;\n1;2;3";
        int calculationResult = new StringAddCalculator().splitAndSum(input);
        assertThat(calculationResult).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력 시 런타임 예외 처리가 발생한다.")
    void splitAndSum_negative() throws Exception {
        String input = "-1,2,3";
        assertThatThrownBy(() -> {
            new StringAddCalculator().splitAndSum(input);
        }).isInstanceOf(RuntimeException.class);
    }
}
