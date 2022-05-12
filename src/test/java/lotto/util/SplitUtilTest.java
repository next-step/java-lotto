package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitUtilTest {

    @Test
    @DisplayName("지정된 구분자(,) 문자열을 분리한다.")
    void split() {
        assertThat(SplitUtil.split("1, 2, 3, 5")).containsExactly("1", "2", "3", "5");
    }

    @Test
    @DisplayName("구분자 없는 경우 그대로 반환한다.")
    void noSeparator() {
        assertThat(SplitUtil.split("1")).containsExactly("1");
    }
}