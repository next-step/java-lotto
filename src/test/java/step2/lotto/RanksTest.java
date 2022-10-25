package step2.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {

    @Test
    void 수익률을_구할_수_있다() {
        List<Rank> rankingAggregation = List.of(Rank.FOURTH);

        Ranks ranks = new Ranks(rankingAggregation);

        int price = 1000;
        assertThat(ranks.yield()).isEqualTo( Rank.FOURTH.prizeAmount() / (rankingAggregation.size() * price));
    }

}
