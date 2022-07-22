package lotto.domain;

import lotto.interfaces.LotteryGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("lotto 당첨 결과 출력 위한 클래스")
    @Test
    void construct() {
        LotteryGame lotteryGame = new AutoLotteryGame();
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        WinningResult winningResult = new WinningResult(lotteryGame, winningNumbers);
        assertThat(winningResult).isNotNull();
    }
}
