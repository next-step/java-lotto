package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null 또는 빈문자 계산")
    public void calculate_with_null_or_empty_value(String input) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 계산")
    public void calculate_with_single_number() throws Exception {
        int result = StringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3", "3,2,1", "1,3,2" })
    @DisplayName("쉼표가 포함된 문자열 계산")
    public void calculate_with_commas(String input) throws Exception {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2:3", "1:2,3" })
    @DisplayName("쉼표와 콜론이 포함된 문자열 계산")
    public void calculate_with_commas_and_colons(String input) throws Exception {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = { "//~\n1~2~3", "//;\n1;2;3", "//!\n1!2!3" })
    @DisplayName("커스텀 구분자가 포함된 문자열 계산")
    public void calculate_with_custom_delimiter(String input) throws Exception {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1,2,3", "1,-2,3", "1,2,-3" })
    @DisplayName("음수가 포함된 문자열 계산")
    public void calculate_with_negative_number(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }
}
