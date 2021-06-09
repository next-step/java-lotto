package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinnerLotteryTest {

    @Test
    @DisplayName("로또번호와 당첨번호의 일치하는 개수를 구한다.")
    void match_test() {
        //given
        WinnerLottery winner = new WinnerLottery(new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6)), new BonusBall(40));
        LotteryNumbers lotteryNumbers = new LotteryNumbers(List.of(1, 2, 10, 24, 30, 33));

        //when
        int matchCount = winner.match(lotteryNumbers);

        //that
        assertThat(matchCount).isEqualTo(2);
    }

    @Test
    @DisplayName("보너스볼은 당첨 번호에 포함되면 안된다.")
    void validateBonusBall_test() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinnerLottery(new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6)), new BonusBall(6))
        );
    }

}
