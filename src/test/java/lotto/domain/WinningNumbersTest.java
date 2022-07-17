package lotto.domain;

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
}
