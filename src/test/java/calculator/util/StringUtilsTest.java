package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilsTest {

    @Test
    @DisplayName("문자열 공백 분리 테스트")
    void split() {
        // given
        String input = "1 + 2 / 7";
        List<String> expected = Arrays.asList("1", "+", "2", "/", "7");

        // when
        List<String> actual = StringUtils.split(input);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("문자열 파싱 테스트 (정상)")
    void parse() {
        // given
        String input = "1";
        int expected = 1;

        // when
        int actual = StringUtils.parse(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열 파싱 테스트 (예외)")
    void parseException() {
        // given
        String input1 = "a";
        String input2 = "1.3";

        // then
        assertThatThrownBy(() -> StringUtils.parse(input1))
                .isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> StringUtils.parse(input2))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("입력값이 비어있는 경우 테스트")
    void isBlank() {
        // given
        String input1 = "";
        String input2 = null;

        // when
        boolean actual1 = StringUtils.isBlank(input1);
        boolean actual2 = StringUtils.isBlank(input2);

        // then
        assertThat(actual1).isTrue();
        assertThat(actual2).isTrue();
    }

    @Test
    @DisplayName("입력값이 비어있는 경우 예외")
    void isBlankException() {
        // given
        String input = "";

        // then
        assertThatThrownBy(() -> StringUtils.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 비어있습니다.");
    }
}