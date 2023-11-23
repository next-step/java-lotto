package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankingTest {

    @Test
    @DisplayName("ranked_non_Ranking.NOT_RANKED 제외한 전체 포함")
    void ranked() {
        assertThat(Ranking.ranked()).containsExactly(Ranking.FIFTH, Ranking.FOURTH, Ranking.THIRD, Ranking.FIRST);
    }
}