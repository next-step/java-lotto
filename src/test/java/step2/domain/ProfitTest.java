package step2.domain;

import org.junit.jupiter.api.Test;
import step2.vo.MatchNumberVO;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    @Test
    void profitAddTest() {
        final Profit actual = new Profit(0);
        actual.add(MatchNumberVO.THREE);
        actual.add(MatchNumberVO.FIVE);

        final long profit = MatchNumberVO.THREE.winnings + MatchNumberVO.FIVE.winnings;
        final Profit expected = new Profit(profit);

        System.out.println(expected);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void calculateProfitRateTest() {
        final Profit actual = new Profit(0);
        actual.add(MatchNumberVO.THREE);
        actual.calculateProfitRate(14000);

        final double expectedProfitRate = MatchNumberVO.THREE.winnings / (double) 14000;
        final Profit expected = new Profit(MatchNumberVO.THREE.winnings, expectedProfitRate);

        System.out.println(actual);
        assertThat(actual).isEqualTo(expected);
    }
}