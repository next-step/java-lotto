package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("winner 객체 생성 테스트")
    void createWinnerTest() {
        Winners winners = new Winners();
        int matchingBall = 6;

        winners.addWinner(matchingBall);
        winners.addWinner(matchingBall);
        winners.addWinner(matchingBall);

        assertThat(winners.getWinnersCount(matchingBall))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("상금이 없을 때 winner 객체 생성 테스트")
    void noPrizeWinnerTest() {
        Winners winners = new Winners();
        int matchingBall = 2;

        winners.addWinner(matchingBall);
        winners.addWinner(matchingBall);
        winners.addWinner(matchingBall);

        assertThat(winners.getWinnersCount(matchingBall))
                .isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"6,2000000000", "5,1500000", "4,50000", "3,5000"})
    @DisplayName("상금 테스트")
    void getPrizeTest(int matchingBall, int prize) {
        Winners winners = new Winners();

        assertThat(winners.getPrize(matchingBall))
                .isEqualTo(prize);
    }

    @Test
    @DisplayName("수익률 테스트 - 하나도 안맞음")
    void getProfitZeroTest() {
        Money amount = Money.initMoney(14000);
        Winners winners = new Winners();
        int matchingBall = 2;

        winners.addWinner(matchingBall);

        assertThat(winners.getProfit(amount))
                .isEqualTo(0.0);
    }

    @Test
    @DisplayName("수익률 테스트 - 손해")
    void getProfitLoseTest() {
        Money amount = Money.initMoney(14000);
        Winners winners = new Winners();
        int matchingBall = 3;

        winners.addWinner(matchingBall);

        assertThat(winners.getProfit(amount))
                .isEqualTo((double) 5000 / 14000);
    }

    @Test
    @DisplayName("수익률 테스트 2장 - 손해")
    void getProfitDoubleLoseTest() {
        Money amount = Money.initMoney(14000);
        Winners winners = new Winners();
        int matchingBall = 3;

        winners.addWinner(matchingBall);
        winners.addWinner(matchingBall);

        assertThat(winners.getProfit(amount))
                .isEqualTo((double) 10000 / 14000);
    }

    @Test
    @DisplayName("수익률 테스트 - 본전치기")
    void getProfitStandardTest() {
        Money amount = Money.initMoney(5000);
        Winners winners = new Winners();
        int matchingBall = 3;

        winners.addWinner(matchingBall);

        assertThat(winners.getProfit(amount))
                .isEqualTo(1.0);
    }

    @Test
    @DisplayName("수익률 테스트 - 수익")
    void getRealProfitTest() {
        Money amount = Money.initMoney(5000);
        Winners winners = new Winners();
        int matchingBall = 4;

        winners.addWinner(matchingBall);
        winners.addWinner(matchingBall);

        assertThat(winners.getProfit(amount))
                .isGreaterThan((double) 10000 / 5000);
    }

}