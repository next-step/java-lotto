package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinLotteryTest {

    @Test
    @DisplayName("로또 당첨 번호 생성 테스트")
    void winLotteryTest(){
        // Given
        final String winNumbersString = "1, 2, 3, 4, 5, 6";
        // When
        WinLottery winLottery = new WinLottery(winNumbersString);
        // Then
        assertThat(winLottery.winLottery().lotteryNumbers()).hasSize(6);
        assertThat(winLottery.winLottery().lotteryNumbers()).contains(1, 2, 3, 4, 5, 6);
    }
}
