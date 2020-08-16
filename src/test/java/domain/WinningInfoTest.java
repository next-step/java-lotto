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
}