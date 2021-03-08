package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {":0", "'':0", "' ':0"}, delimiter = ':')
    @DisplayName("빈문자열 또는 널은 0으로 취급하는지 테스트")
    void splitAndSum_null_or_empty_string(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("쉼표구분자로 문자 합산 테스트")
    void splitAndSum_with_comma_delimiter() {
        String input = "1,2";
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론 구분자로 문자 합산 테스트")
    void splitAndSum_with_colon_delimiter() {
        String input = "1:2";
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론과쉼표 복합 구분자로 문자 합산 테스트")
    void splitAndSum_with_comma_and_colon_delimiter() {
        String input = "1:2,4";
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("구분자 없이 문자 합산 테스트")
    void splitAndSum_without_any_delimiter() {
        String input = "1";
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("커스텀 구분자로 문자 합산 테스트")
    void splitAndSum_with_custom_delimiter() {
        String input = "//;\n1;5;3";
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(9);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n-1;5;344", "5,-322", "422:-23,1"})
    @DisplayName("음수 포함시 예외 발생 테스트")
    void splitAndSum_with_negative_number(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\nadd;bdd;3", "5,asdf", "4:gasdfa,1"})
    @DisplayName("숫자가 아닌 문자 포함시 예외 발생 테스트")
    void splitAndSum_with_not_numeric_input(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input));
    }


}
