package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatingNumbersTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null 또는 빈 문자")
    public void create_nullOrEmpty(String param) {
        // given when then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(
                        () -> new CalculatingNumbers(param)
                ).withMessageMatching("수식을 입력해 주세요.");
    }

    @Test
    @DisplayName("음수 입력 불가")
    public void create_negative() {
        // given when then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(
                        () -> new CalculatingNumbers("-1,2,3")
                ).withMessageMatching("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("숫자 외의 수 입력 불가")
    public void create_NumberFormat() {
        // given when then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(
                        () -> new CalculatingNumbers("a,2,3")
                ).withMessageMatching("양의 정수가 아닙니다. 입력값을 확인해 주세요.");
    }

    @Test
    @DisplayName("합 - 숫자 하나")
    public void sum_singleNumber() {
        // given when
        CalculatingNumbers calculatingNumbers = new CalculatingNumbers("1");

        // then
        assertThat(calculatingNumbers.sum()).isEqualTo(1);
    }

    @Test
    @DisplayName("합 - 쉼표 구분자")
    public void sum_commaDelimiter() {
        // given when
        CalculatingNumbers calculatingNumbers = new CalculatingNumbers("1,2");

        // then
        assertThat(calculatingNumbers.sum()).isEqualTo(3);
    }

    @Test
    @DisplayName("합 - 쉼표와 콜론 구분자")
    public void sum_commaOrColonDelimiter() {
        // given when
        CalculatingNumbers calculatingNumbers = new CalculatingNumbers("1,2,3");

        // then
        assertThat(calculatingNumbers.sum()).isEqualTo(6);
    }

    @Test
    @DisplayName("합 - 커스텀 구분자")
    public void sum_customDelimiter() {
        // given when
        CalculatingNumbers calculatingNumbers = new CalculatingNumbers("//;\n1;2;3");

        // then
        assertThat(calculatingNumbers.sum()).isEqualTo(6);
    }

}