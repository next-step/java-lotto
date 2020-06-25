package calcurator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈문자")
    void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
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
    @CsvSource(value = {"1,2=3", "3,6=9"}, delimiter = '=')
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void splitAndSum_쉼표구분자(String input, int expectedCount) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2=3", "3:6,2=11"}, delimiter = '=')
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void splitAndSum_컴마와콜론구분자(String input, int expectedCount) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "3,-6,2"})
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)")
    void splitAndSum_음수전달시_예외처리(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("양수를 입력해주세요.");
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    void splitAndSum_커스텀구분자() {
        String input = "//;\n1;2;3";
        int expectedCount = 6;
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expectedCount);
    }
}