package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    @Test
    @DisplayName("한 개의 로또 당첨 여부 테스트")
    void match_with_winning_lottery() {
        Lottery lottery = new Lottery(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );
        WinningLottery winningLottery = new WinningLottery("1,2,3,4,5,6");

        assertThat(lottery.match(winningLottery)).isEqualTo(6);
    }
}