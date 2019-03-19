package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoCalculatorTest {
    private List<Rank> ranks = new ArrayList<>();

    @Before
    public void setUp() {
        ranks.add(Rank.Third);
        ranks.add(Rank.Fourth);
        ranks.add(Rank.Fourth);
        ranks.add(Rank.None);
    }

    @Test
    public void get_rank_grouping() {
        Map<Rank, Long> rankGroup = LottoCalculator.makeRankGroup(ranks);
        assertThat(rankGroup.get(Rank.Third)).isEqualTo(1L);
        assertThat(rankGroup.get(Rank.Fourth)).isEqualTo(2L);
        assertThat(rankGroup.get(Rank.None)).isEqualTo(1L);
    }

    @Test
    public void calculate_prize_money() {
        Long prizeMoney = LottoCalculator.calculatePrizeMoney(ranks);
        assertThat(prizeMoney).isEqualTo(60000L);
    }

    @Test
    public void calculate_profit_rate() {
        Double profitRate = LottoCalculator.calculateProfitRate(ranks);
        assertThat(profitRate).isEqualTo(15.0);
    }
}
