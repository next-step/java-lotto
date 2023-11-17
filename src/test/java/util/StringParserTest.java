package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {
    @DisplayName("parseWhiteSpace() 메서드 테스트")
    @Test
    void parse_white_space_success() {
        // given
        final String input = "2 + 3 * 4 / 2";

        // when
        final String[] result = StringParser.parseWhiteSpace(input);

        // then
        assertThat(result).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

}
