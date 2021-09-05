package step2;

import org.junit.jupiter.api.Test;
import step2.vo.MatchNumber;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    @Test
    void profitAddTest() {
        final Profit actual = new Profit(0);
        actual.add(MatchNumber.THREE);
        actual.add(MatchNumber.FIVE);

        final long profit = MatchNumber.THREE.winnings + MatchNumber.FIVE.winnings;
        final Profit expected = new Profit(profit);

        System.out.println(expected);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void calculateProfitRateTest() {
        final Profit actual = new Profit(0);
        actual.add(MatchNumber.THREE);
        actual.calculateProfitRate(14000);

        final double expectedProfitRate = MatchNumber.THREE.winnings / (double) 14000;
        final Profit expected = new Profit(MatchNumber.THREE.winnings, expectedProfitRate);

        System.out.println(actual);
        assertThat(actual).isEqualTo(expected);
    }
}