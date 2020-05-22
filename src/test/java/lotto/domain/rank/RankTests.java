package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.rank.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTests {
    @DisplayName("돈을 받을 수 있는 순위인지 알려줄 수 있다.")
    @Test
    void canGetPrizeTest() {
        assertThat(Rank.canGetPrize(FIRST)).isTrue();
        assertThat(Rank.canGetPrize(SIXTH)).isFalse();
    }
}
