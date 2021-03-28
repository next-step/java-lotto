package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    @Test
    public void yield() {
        // given
        Statistics statistics = new Statistics(Arrays.asList(new Rank[]{Rank.FIFTH}));
        int purchaseAmount = 10000;
        double expectYield = 0.5;

        // when
        double resultYield = statistics.yield(purchaseAmount);

        // then
        assertThat(resultYield).isEqualTo(expectYield);
    }

    @Test
    public void isLoss() {
        // given
        Statistics statistics = new Statistics(Arrays.asList(new Rank[]{Rank.FIFTH}));
        int purchaseAmount = 10000;

        // when
        Boolean resultIsLoss = statistics.isLoss(purchaseAmount);

        // then
        assertThat(resultIsLoss).isTrue();
    }
}
