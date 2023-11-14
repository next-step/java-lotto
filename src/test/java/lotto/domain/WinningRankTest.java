package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankTest {

    private Map<Rank, Long> winningRanks = new HashMap<>();
    
    @Test
    @DisplayName("4등 3개 3등 1개에 당첨이 된경우 최종 상금은 65,000원 이다")
    void calcTotalWinningPrice() {
        this.winningRanks.put(Rank.FOURTH, 3L);
        this.winningRanks.put(Rank.THIRD, 1L);

        WinningRank winningRank = new WinningRank(this.winningRanks);

        assertThat(winningRank.calcTotalWinningPrice()).isEqualTo(new Money(65_000));
    }
}