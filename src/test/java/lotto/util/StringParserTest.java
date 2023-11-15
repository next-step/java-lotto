package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {

    @Test
    @DisplayName("기본 구분자로 문자열을 분리하여 숫자로 된 리스트를 구할 수 있다.")
    void success_string_parse() {
        String text = "1, 2, 3, 4, 5, 6";
        int size = 6;

        List<Integer> parseText = StringParser.parseToInts(text);

        assertThat(parseText).hasSize(size)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

}
