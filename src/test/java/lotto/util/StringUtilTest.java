package lotto.util;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {
    @Test
    @DisplayName("쉼표로 구분된 숫자 문자열을 정수 리스트로 변환")
    void splitNormalCase() {
        String input = "1, 2, 3, 4, 5";

        List<Integer> result = StringUtil.split(input);

        assertThat(result)
            .hasSize(5)
            .containsExactly(1, 2, 3, 4, 5);
    }
}
