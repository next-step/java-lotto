package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null 또는 빈 문자")
    public void splitAndSum_nullOrEmpty(String param) {
        // given when
        int result = StringAddCalculator.splitAndSum(param);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나")
    public void splitAndSum_singleNumber() {
        // given when
        int result = StringAddCalculator.splitAndSum("1");

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자")
    public void splitAndSum_commaDelimiter() {
        // given when
        int result = StringAddCalculator.splitAndSum("1,2");

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표와 콜론 구분자")
    public void splitAndSum_commaOrColonDelimiter() {
        // given when
        int result = StringAddCalculator.splitAndSum("1,2:3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자")
    public void splitAndSum_customDelimiter() {
        // given when
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력 불가")
    public void splitAndSum_negative() {
        // given when then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(
                        () -> StringAddCalculator.splitAndSum("-1,2,3")
                ).withMessageMatching("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("숫자 외의 수 입력 불가")
    public void splitAndSum_NumberFormat() {
        // given when then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(
                        () -> StringAddCalculator.splitAndSum("a,2,3")
                ).withMessageMatching("양의 정수가 아닙니다. 입력값을 확인해 주세요.");
    }
}