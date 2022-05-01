package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitUtilTest {

    @Test
    @DisplayName("'1, 2, 3, 5' 를 입력하면 {'1', '2', '3', '5'} 문자열 배열을 반환한다.")
    void split() {
        assertThat(SplitUtil.split("1, 2, 3, 5")).isEqualTo(new String[]{"1", "2", "3", "5"});
    }

}