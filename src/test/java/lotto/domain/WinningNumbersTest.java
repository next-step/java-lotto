package lotto.domain;

import lotto.interfaces.LotteryGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningNumbersTest {

    @DisplayName("당첨번호에 보너스 번호를 입력하여 WinningNumbers 생성")
    @Test
    void construct_withBonusNumber() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        assertAll(
                () -> assertThat(winningNumbers.getWinningNumberList().get(0)).isEqualTo(LotteryNumber.of(1)),
                () -> assertThat(winningNumbers.getWinningNumberList().get(1)).isEqualTo(LotteryNumber.of(2)),
                () -> assertThat(winningNumbers.getWinningNumberList().get(2)).isEqualTo(LotteryNumber.of(3)),
                () -> assertThat(winningNumbers.getWinningNumberList().get(3)).isEqualTo(LotteryNumber.of(4)),
                () -> assertThat(winningNumbers.getWinningNumberList().get(4)).isEqualTo(LotteryNumber.of(5)),
                () -> assertThat(winningNumbers.getWinningNumberList().get(5)).isEqualTo(LotteryNumber.of(6)),
                () -> assertThat(winningNumbers.getBonusNumber()).isEqualTo(7)
        );
    }

    @DisplayName("lotto 당철결과 출력 (1등)")
    @Test
    void match_first() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,3,4,5,6");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        WinningResult winningResult = new WinningResult(lotteryGame, winningNumbers);
        Rank rank = winningResult.result();
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("lotto 당철결과 출력 (2등)")
    @Test
    void match_second() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,3,4,5,7");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        Rank rank = winningNumbers.match(lotteryGame);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("lotto 당철결과 출력 (3등)")
    @Test
    void match_third() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,3,4,5,8");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        Rank rank = winningNumbers.match(lotteryGame);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("lotto 당철결과 출력 (4등)")
    @Test
    void match_fourth() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,3,4,8,9");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        Rank rank = winningNumbers.match(lotteryGame);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("lotto 당철결과 출력 (5등)")
    @Test
    void match_fifth() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,3,8,9,10");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        Rank rank = winningNumbers.match(lotteryGame);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("lotto 당철결과 출력 (미당청)")
    @Test
    void match_miss() {
        LotteryGame lotteryGame = new ManualLotteryGame("1,2,8,9,10,11");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        Rank rank = winningNumbers.match(lotteryGame);
        assertThat(rank).isEqualTo(Rank.MISS);
    }
}
