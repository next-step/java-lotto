package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class WinningInfoTest {

    @Test
    @DisplayName("맞춘 숫자를 증가시킨다.")
    void increaseTest() {
        WinningInfo winningInfo = WinningInfo.of(Rank.FIRST);
        winningInfo.increaseWinningNumber();
//        BigDecimal expected = Rank.FIRST.getWinningMoney();
        assertThat(winningInfo.getWinningNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 횟수와 당첨 순위 금액의 곱을 반환한다.")
    void getMultiplyWinningMoneyTest() {
        WinningInfo winningInfo = WinningInfo.of(Rank.FIRST);
        winningInfo.increaseWinningNumber();
        winningInfo.increaseWinningNumber();
        BigDecimal expected = Rank.FIRST.getWinningMoney().multiply(new BigDecimal(2));
        assertThat(winningInfo.getMultiplyWinningMoney()).isEqualTo(expected);
    }
}