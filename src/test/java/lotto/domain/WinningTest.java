package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {

    @DisplayName("당첨갯수가 3개 이상이면 winner에 추가된다.")
    @Test
    void addWinnerSuccessTest() {
        final Winning winning = new Winning();
        winning.addWinning(3);

        final int winnerCount = winning.getWinnerCount(Rank.FIFTH);
        assertThat(winnerCount).isEqualTo(1);
    }

    @DisplayName("당첨갯수가 3개 미만이면 winner에 추가되지 않는다.")
    @Test
    void addWinnerFailTest() {
        final Winning winner = new Winning();
        winner.addWinning(2);

        final int winnerCount = winner.getWinnerCount(Rank.FIFTH);
        assertThat(winnerCount).isEqualTo(0);
    }

    @DisplayName("당첨 번호의 합산 금액 과 구입금액으로 수익률을 계산한다.")
    @Test
    void getReturnRateTest() {
        final Winning winner = new Winning();
        winner.addWinning(6);

        final double returnRate = winner.getReturnRate(new Amount(10000));

        assertThat(returnRate).isEqualTo(200000);
    }
}