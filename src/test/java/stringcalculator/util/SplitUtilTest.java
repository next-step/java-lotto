package stringcalculator.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringcalculator.util.SplitUtil.*;

public class SplitUtilTest {
    @Test
    void 문자열을_자른다() {
        String input = "2 + 3 * 4 / 2";
        List<String> actual = split(input);
        List<String> expected = List.of("2", "+", "3", "*", "4", "/", "2");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 문자열_size_는_홀수가_아니면_예외처리한다() {
        assertThatThrownBy(() -> {
            String input = "2 + 3 * 4 / ";
            split(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOW_BELOW_THREE_OR_LIST_SIZE_EVEN_NUMBER);
    }
}
