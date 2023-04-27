package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    Map<Statistics, Integer> winnersCount = new EnumMap<>(Statistics.class);

    @Test
    @DisplayName("상금이 없을 때 winner 객체 생성 테스트")
    void noPrizeWinnerTest() {
        winnersCount.put(Statistics.MISS, 3);
        Winners winners = new Winners(winnersCount);

        assertThat(winners.getWinnersMatchingCount(Statistics.MISS))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("수익률 테스트 - 하나도 안맞음")
    void getProfitZeroTest() {
        Money amount = Money.from(14000);
        winnersCount.put(Statistics.MISS, 14);
        Winners winners = new Winners(winnersCount);

        assertThat(winners.getProfit(amount))
                .isEqualTo(0.0);
    }

    @Test
    @DisplayName("수익률 테스트 - 손해")
    void getProfitLoseTest() {
        Money amount = Money.from(14000);
        winnersCount.put(Statistics.FIFTH, 1);
        Winners winners = new Winners(winnersCount);

        assertThat(winners.getProfit(amount))
                .isEqualTo((double) 5000 / 14000);
    }

    @Test
    @DisplayName("수익률 테스트 2장 - 손해")
    void getProfitDoubleLoseTest() {
        Money amount = Money.from(14000);
        winnersCount.put(Statistics.FIFTH, 2);
        Winners winners = new Winners(winnersCount);

        assertThat(winners.getProfit(amount))
                .isEqualTo((double) 10000 / 14000);
    }

    @Test
    @DisplayName("수익률 테스트 - 본전치기")
    void getProfitStandardTest() {
        Money amount = Money.from(5000);
        winnersCount.put(Statistics.FIFTH, 1);
        Winners winners = new Winners(winnersCount);

        assertThat(winners.getProfit(amount))
                .isEqualTo(1.0);
    }

    @Test
    @DisplayName("수익률 테스트 - 수익")
    void getRealProfitTest() {
        Money amount = Money.from(5000);
        winnersCount.put(Statistics.FIFTH, 2);
        Winners winners = new Winners(winnersCount);

        assertThat(winners.getProfit(amount))
                .isEqualTo((double) 10000 / 5000);
    }

}