package step2.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.ProfitTestUtil;
import step2.vo.Rank;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {

    @Test
    @DisplayName("5등(3개 일치) 1개, 총 1개 구매에 대한 통계")
    void addTest() {
        final Profit profit = new Profit();
        profit.add(Rank.FIFTH);
        System.out.println(profit);

        final Profit expected = ProfitTestUtil.createProfit(Rank.FIFTH, 1, 1);
        System.out.println(expected);
        assertThat(profit).isEqualTo(expected);
    }

    @Test
    @DisplayName("4등(4개 일치) 2개, 총 2개 구매에 대한 통계")
    void addTest2() {
        final Profit profit = new Profit();
        profit.add(Rank.FOURTH);
        profit.add(Rank.FOURTH);

        final Profit expected = ProfitTestUtil.createProfit(Rank.FOURTH, 2, 2);
        System.out.println(expected);
        assertThat(profit).isEqualTo(expected);
    }

    @Test
    @DisplayName("2등(5개일치, 보너스) 2개, 미당첨 1개, 총 3개 구매에 대한 통계")
    void addTest3() {
        final Profit actual = new Profit();
        actual.add(Rank.SECOND);
        actual.add(Rank.SECOND);
        actual.add(Rank.NONE);

        final Profit expected = ProfitTestUtil.createProfit(Rank.SECOND, 2, 3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("건당 수익률 계산 테스트")
    void profitRateTest() {
        final int LOTTO_PRICE = 1000;

        final Profit profit = new Profit();
        profit.add(Rank.NONE);
        profit.add(Rank.FIFTH);
        final ProfitRate firstActual = profit.profitRate();

        final ProfitRate firstExpected = new ProfitRate((long) 5000 / ((double) 2 * LOTTO_PRICE));
        assertThat(firstActual).isEqualTo(firstExpected);

        profit.add(Rank.FIFTH);
        final ProfitRate secondActual = profit.profitRate();
        final ProfitRate secondExpected = new ProfitRate(10000 / ((double) 3 * LOTTO_PRICE));
        assertThat(secondActual).isEqualTo(secondExpected);
        assertThat(firstActual).isNotEqualTo(secondActual);
    }

}