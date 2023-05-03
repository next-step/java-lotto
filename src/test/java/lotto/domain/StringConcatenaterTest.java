package lotto.domain;

import lotto.util.StringConcatenater;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringConcatenaterTest {
    @Test
    void 여러_문자열을_합칠_수_있다() {
        assertThat(StringConcatenater.concatStrings("a", "b", "c")).isEqualTo("abc");
    }

    @Test
    void 문자열을_문자열_배열과_합칠_수_있다() {
        assertThat(StringConcatenater.concatStrings("a", new String[]{"b", "c"})).isEqualTo("abc");
    }
}
