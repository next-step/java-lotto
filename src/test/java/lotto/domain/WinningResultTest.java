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

    @DisplayName("lotto 당철결과 출력 (1등)")
    @Test
    void result_first() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,3,4,5,6");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        WinningResult winningResult = new WinningResult(lotteryGame, winningNumbers);
        Rank rank = winningResult.result();
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("lotto 당철결과 출력 (2등)")
    @Test
    void result_second() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,3,4,5,7");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        WinningResult winningResult = new WinningResult(lotteryGame, winningNumbers);
        Rank rank = winningResult.result();
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("lotto 당철결과 출력 (3등)")
    @Test
    void result_third() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,3,4,5,8");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        WinningResult winningResult = new WinningResult(lotteryGame, winningNumbers);
        Rank rank = winningResult.result();
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("lotto 당철결과 출력 (4등)")
    @Test
    void result_fourth() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,3,4,8,9");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        WinningResult winningResult = new WinningResult(lotteryGame, winningNumbers);
        Rank rank = winningResult.result();
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("lotto 당철결과 출력 (5등)")
    @Test
    void result_fifth() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,3,8,9,10");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        WinningResult winningResult = new WinningResult(lotteryGame, winningNumbers);
        Rank rank = winningResult.result();
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("lotto 당철결과 출력 (미당청)")
    @Test
    void result_miss() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,8,9,10,11");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        WinningResult winningResult = new WinningResult(lotteryGame, winningNumbers);
        Rank rank = winningResult.result();
        assertThat(rank).isEqualTo(Rank.MISS);
    }
}
