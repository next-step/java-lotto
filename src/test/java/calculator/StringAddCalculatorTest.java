package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈문자 계산")
    void testSplitAndSumNullOrEmptyInput(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 계산")
    void testSplitAndSumSingleNumber() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자 계산")
    void testSplitAndSumInputWithComma() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자 계산")
    void testSplitAndSumInputWithCommaAndColon() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자")
    void testSplitAndSumCustomDelimiters() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이와의 문자 존재 시 예외 발생")
    void testSplitAndSumNotParsableNumber() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("d:1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수 존재 시 예외 발생")
    void testSplitAndSumNegativeNumber() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1:1"))
                .isInstanceOf(RuntimeException.class);
    }

}
