package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchedTest {

    @Test
    @DisplayName("당첨 여부에 따른 Matched 타입 리턴 확인")
    void valueOfMatched() {
        assertThat(Matched.valueOf(5, true)).isEqualTo(Matched.FIVE_AND_BONUS);
        assertThat(Matched.valueOf(5, false)).isEqualTo(Matched.FIVE);
    }
}