package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("당첨된 번호의 개수에 따라 등수를 반환한다")
    @Test
    void getRanks() {
        Rank rank = Rank.getRank(4, true);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("일치하는_당첨번호가_3미만일_경우_MISS반환")
    @Test
    void when_matchCount_is_less_than_3_then_return_MISS() {
        Rank rank = Rank.getRank(2, false);
        assertThat(rank).isEqualTo(Rank.MISS);
    }
}
