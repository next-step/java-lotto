package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringSplitterTest {

    @Test
    void 숫자를_나누어_생성이_가능하다() {
        String input = "1 + 2";

        List<Integer> actual = StringSplitter.splitNumbers(input);
        List<Integer> expected = List.of(1, 2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 문자를_나누어_생성이_가능하다() {
        String input = "1 + 2 - 3";

        List<String> actual = StringSplitter.splitOperation(input);
        List<String> expected = List.of("+", "-");

        assertThat(actual).isEqualTo(expected);
    }

}
