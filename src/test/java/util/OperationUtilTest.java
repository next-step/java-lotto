package util;

import org.junit.jupiter.api.BeforeEach;
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

    @Test
    public void 문자열_식을_입력했을때_문자_배열_반환() {
        assertThat(OperationUtil.splitString(line)).isEqualTo(expected);
    }

    @Test
    public void 빈_문자열_입력시_예외_반환() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    OperationUtil.splitString(blank);
                }).withMessageMatching("연산식을 입력해주세요.");
    }
}