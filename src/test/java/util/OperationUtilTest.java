package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class OperationUtilTest {

    String line;
    String blank;
    String[] expected;

    @BeforeEach
    void setUp() {
        line = "3 + 5 / 2 * 3";
        blank = "";
        expected = new String[]{"3", "+", "5", "/", "2", "*", "3"};
    }

    @DisplayName("문자열로 된 계산식을 입력했을 때 숫자와 기호로 나눠진 문자 배열 반환")
    @Test
    void splitStringIntoNumbersAndOperators() {
        assertThat(OperationUtil.splitString(line)).isEqualTo(expected);
    }

    @DisplayName("빈 문자열을 계산식으로 입력하면 예외 반환")
    @Test
    void throwExceptionWhenEnteredEmptyString() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    OperationUtil.splitString(blank);
                }).withMessageMatching("연산식을 입력해주세요.");
    }
}