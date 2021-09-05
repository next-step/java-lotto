package step2.domain;

import org.junit.jupiter.api.Test;
import step2.vo.Rank;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    @Test
    void profitAddTest() {
        final Profit actual = new Profit(0);
        actual.add(Rank.FIFTH);
        actual.add(Rank.THIRD);

        final long profit = Rank.FIFTH.winnings + Rank.THIRD.winnings;
        final Profit expected = new Profit(profit);

        System.out.println(expected);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void calculateProfitRateTest() {
        final Profit actual = new Profit(0);
        actual.add(Rank.FIFTH);
        actual.calculateProfitRate(14000);

        final double expectedProfitRate = Rank.FIFTH.winnings / (double) 14000;
        final Profit expected = new Profit(Rank.FIFTH.winnings, expectedProfitRate);

        System.out.println(actual);
        assertThat(actual).isEqualTo(expected);
    }
}