package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 Empty String일 경우 계산 결과확인 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("값이하나 일경우 계산 결과확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "0:0"}, delimiter = ':')
    public void splitAndSum_숫자하나(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("쉼표를 구분자로한 문자열의 계산 결과확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "1,2,3:6", "0,2,10:12"}, delimiter = ':')
    public void splitAndSum_쉼표구분자(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("쉼표 또는 콜론이 복합적으로 구성된 문자열의 계산 결과확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3|6", "1,2:3|6", "0,2:10,1|13"}, delimiter = '|')
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀구분자로 구성된 문자열의 계산 결과확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//#\n1#2#3"})
    public void splitAndSum_custom_구분자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수가 포함된 문자열의 계산시 Exception 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,2,-3"})
    public void splitAndSum_negative(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}
