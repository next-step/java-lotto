package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {

    @DisplayName("숫자와 콤마로 구성된 문자열을 split")
    @Test
    void split() {
        // given
        String inputText = "1, 2, 3, 4, 5, 6";

        // when
        List<String> split = StringParser.split(inputText);

        // then
        assertThat(split.get(0)).isEqualTo("1");
        assertThat(split.get(1)).isEqualTo("2");
        assertThat(split.get(2)).isEqualTo("3");
        assertThat(split.get(3)).isEqualTo("4");
        assertThat(split.get(4)).isEqualTo("5");
        assertThat(split.get(5)).isEqualTo("6");
    }
}
