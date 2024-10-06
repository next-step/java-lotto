package stringcalculator.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SplitUtilTest {
    @Test
    void 문자열을_자른다() {
        String input = "2 + 3 * 4 / 2";
        List<String> actual = SplitUtil.split(input);
        List<String> expected = List.of("2", "+", "3", "*", "4", "/", "2");
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
