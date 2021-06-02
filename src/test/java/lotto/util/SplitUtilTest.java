package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SplitUtilTest {

    @DisplayName("문자열 입력값을 받아 숫자 리스트로 반환")
    @Test
    void split() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> numbers = SplitUtil.fromStringToList(input);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}