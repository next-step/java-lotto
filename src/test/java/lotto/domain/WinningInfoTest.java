package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningInfoTest {

    @Test
    @DisplayName("당첨금 확인 Test")
    void totalWinningMoney() {
        WinningInfo winningInfo = new WinningInfo();
        winningInfo.saveWinningInfo(Rank.FOUR);
        int winningMoney = winningInfo.totalWinningMoney();

        assertThat(winningMoney).isEqualTo(5000);
    }
}