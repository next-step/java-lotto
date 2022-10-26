package step2.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {

    @Test
    void 수익률을_구할_수_있다() {
        List<Rank> rankingAggregation = List.of(Rank.FOURTH);

        Ranks ranks = new Ranks(rankingAggregation);

        int price = 1000;
        assertThat(ranks.yield()).isEqualTo( Rank.FOURTH.prizeAmount() / (rankingAggregation.size() * price));
    }

    @Test
    void 일치_지표를_구할_수_있다() {
        List<Rank> rankingAggregation = List.of(Rank.FOURTH);

        Ranks ranks = new Ranks(rankingAggregation);

        Map<Rank, Long> statisticsRanks = Map.ofEntries(
                Map.entry(Rank.FIRST, 0L),
                Map.entry(Rank.SECOND, 0L),
                Map.entry(Rank.THIRD, 0L),
                Map.entry(Rank.FOURTH, 1L)
        );
        assertThat(ranks.matchIndicators()).isEqualTo(statisticsRanks);
    }

}
