package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("winner 객체 생성 테스트")
    void createWinnerTest() {
        Winners winners = new Winners();
        int matchingBall = 6;

        winners.addWinner(matchingBall, false);
        winners.addWinner(matchingBall, false);
        winners.addWinner(matchingBall, false);

        assertThat(winners.getWinnersMatchingCount(Statistics.FIRST))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("상금이 없을 때 winner 객체 생성 테스트")
    void noPrizeWinnerTest() {
        Winners winners = new Winners();
        int matchingBall = 2;

        winners.addWinner(matchingBall, false);
        winners.addWinner(matchingBall, false);
        winners.addWinner(matchingBall, false);

        assertThat(winners.getWinnersMatchingCount(Statistics.MISS))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("수익률 테스트 - 하나도 안맞음")
    void getProfitZeroTest() {
        Money amount = Money.initMoney(14000);
        Winners winners = new Winners();
        int matchingBall = 2;

        winners.addWinner(matchingBall, false);

        assertThat(winners.getProfit(amount))
                .isEqualTo(0.0);
    }

    @Test
    @DisplayName("수익률 테스트 - 손해")
    void getProfitLoseTest() {
        Money amount = Money.initMoney(14000);
        Winners winners = new Winners();
        int matchingBall = 3;

        winners.addWinner(matchingBall, false);

        assertThat(winners.getProfit(amount))
                .isEqualTo((double) 5000 / 14000);
    }

    @Test
    @DisplayName("수익률 테스트 2장 - 손해")
    void getProfitDoubleLoseTest() {
        Money amount = Money.initMoney(14000);
        Winners winners = new Winners();
        int matchingBall = 3;

        winners.addWinner(matchingBall, false);
        winners.addWinner(matchingBall, false);

        assertThat(winners.getProfit(amount))
                .isEqualTo((double) 10000 / 14000);
    }

    @Test
    @DisplayName("수익률 테스트 - 본전치기")
    void getProfitStandardTest() {
        Money amount = Money.initMoney(5000);
        Winners winners = new Winners();
        int matchingBall = 3;

        winners.addWinner(matchingBall, false);

        assertThat(winners.getProfit(amount))
                .isEqualTo(1.0);
    }

    @Test
    @DisplayName("수익률 테스트 - 수익")
    void getRealProfitTest() {
        Money amount = Money.initMoney(5000);
        Winners winners = new Winners();
        int matchingBall = 4;

        winners.addWinner(matchingBall, false);
        winners.addWinner(matchingBall, false);

        assertThat(winners.getProfit(amount))
                .isGreaterThan((double) 10000 / 5000);
    }

}