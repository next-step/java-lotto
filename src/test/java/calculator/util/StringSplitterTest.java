package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {
    @Test
    @DisplayName("문자열 공백 분리 테스트")
    void split() {
        // given
        String input = "1 + 2 / 7";
        List<String> expected = List.of("1", "+", "2", "/", "7");

        // when
        List<String> actual = StringSplitter.splitWithWhiteSpace(input);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }
}