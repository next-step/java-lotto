package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoAnalyzerTest {
    private List<Rank> ranks = new ArrayList<>();
    private Long totalPrize;

    @Before
    public void setUp() {
        ranks.add(Rank.Third);
        ranks.add(Rank.Fourth);
        ranks.add(Rank.Fourth);
        ranks.add(Rank.None);

        totalPrize = ranks.stream().mapToLong(Rank::getPrizeMoney).sum();
    }

    @Test
    public void 순위목록을_그룹핑한다() {
        Map<Rank, Long> rankGroup = LottoAnalyzer.makeWinGroup(ranks);
        assertThat(rankGroup.get(Rank.Third)).isEqualTo(1L);
        assertThat(rankGroup.get(Rank.Fourth)).isEqualTo(2L);
    }

    @Test
    public void 총_당첨금을_계산한다() {
        Long prizeMoney = LottoAnalyzer.calculatePrizeMoney(ranks);
        assertThat(prizeMoney).isEqualTo(totalPrize);
    }

    @Test
    public void 수익률을_계산한다() {
        Double profitRate = LottoAnalyzer.calculateProfitRate(ranks);
        assertThat(profitRate).isEqualTo(
            totalPrize.doubleValue() / (ranks.size() * LottoMachine.LOTTO_PRICE));
    }
}
