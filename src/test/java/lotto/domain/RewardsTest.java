package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {
    @Test
    void 로또_결과_테스트() {
        Rewards rewards = new Rewards(List.of(Rank.FIRST, Rank.SECOND, Rank.FIFTH, Rank.FIFTH));
        assertThat(rewards.getMatchCountsByRank(Rank.FIRST)).isEqualTo(1);
        assertThat(rewards.getMatchCountsByRank(Rank.SECOND)).isEqualTo(1);
        assertThat(rewards.getMatchCountsByRank(Rank.FIFTH)).isEqualTo(2);
    }

    @Test
    void 수익률_테스트() {
        int initialAmount = 100000;
        Rewards rewards = new Rewards(List.of(Rank.FIFTH, Rank.FOURTH));
        assertThat(rewards.getRateOfReturn(initialAmount)).isEqualTo(0.55);
    }
}