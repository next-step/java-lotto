package caculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class UtilTest {

    @Test
    void 문자열을_공백을_기준으로_분할한다() {
        // given
        final String input = "1 + 2 + 3";

        // when
        final List<String> result = Util.split(input);

        // then
        assertThat(result).containsExactly("1", "+", "2", "+", "3");
    }
}
