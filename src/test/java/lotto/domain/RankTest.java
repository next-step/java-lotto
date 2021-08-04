package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RankTest {

    @DisplayName("맞춘 횟수에 맞는 등수를 가져온다.")
    @Test
    void returnRank_맞춘_횟수에_맞는_등수() {
        assertThat(Rank.returnRank(new MatchingCount())).isEqualTo(Rank.MISS);
        assertThat(Rank.returnRank(new MatchingCount(1))).isEqualTo(Rank.MISS);
        assertThat(Rank.returnRank(new MatchingCount(2))).isEqualTo(Rank.MISS);
        assertThat(Rank.returnRank(new MatchingCount(3))).isEqualTo(Rank.FOURTH);
        assertThat(Rank.returnRank(new MatchingCount(4))).isEqualTo(Rank.THIRD);
        assertThat(Rank.returnRank(new MatchingCount(5))).isEqualTo(Rank.SECOND);
        assertThat(Rank.returnRank(new MatchingCount(6))).isEqualTo(Rank.FIRST);
    }

    @DisplayName("등수에 맞는 금액을 가져온다.")
    @Test
    void getWinningMoney_등수에_맞는_금액() {
        assertThat(Rank.MISS.getWinningMoney()).isEqualTo(0);
        assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(5_000);
        assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(50_000);
        assertThat(Rank.SECOND.getWinningMoney()).isEqualTo(1_500_000);
        assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2000_000_000);
    }

}
