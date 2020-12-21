package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lottery;
import step2.domain.WinningLottery;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    @Test
    @DisplayName("자동으로 생성된 로또 번호 range가 1이상 45이하인지 테스트")
    void is_between_1_to_45() {
        Lottery lottery = new Lottery();
        assertThat(
                lottery.getSelectedNumbers()
                        .stream()
                        .allMatch(number -> number >= 1 && number <= 45)
        ).isEqualTo(true);
    }

    @Test
    @DisplayName("한 개의 로또 당첨 여부 테스트")
    void match_with_winning_lottery() {
        Lottery lottery = new Lottery(Arrays.asList(1,2,3,4,5,6));
        WinningLottery winningLottery = new WinningLottery("1,2,3,4,5,6");

        lottery.match(winningLottery);
        assertThat(lottery.getMatched()).isEqualTo(6);
    }
}