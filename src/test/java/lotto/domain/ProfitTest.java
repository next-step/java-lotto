package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {
    @DisplayName("총 횟수 대비 로또 수익률을 계산할 수 있다.")
    @Test
    void profitTest() {
        // given
        HashMap<Rank, Integer> ranks = new HashMap<>();
        ranks.put(Rank.FIFTH, 1);
        int totalCount = 14;

        // when
        Profit profit = new Profit(ranks, totalCount);

        // then
        assertThat(profit).isEqualTo(new Profit(0.35));
    }

    @DisplayName("2등 당첨 통계 테스트")
    @Test
    void secondRankProfitTest() {
        // given
        HashMap<Rank, Integer> ranks = new HashMap<>();
        ranks.put(Rank.SECOND, 1);
        int totalCount = 14;

        // when
        Profit profit = new Profit(ranks, totalCount);

        // then
        // NOTE. 14_000원 투자해서 30_000_000 받았으면 수익률은
        assertThat(profit).isEqualTo(new Profit(2142.85));
    }
}
