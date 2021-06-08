package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusBallTest {

    @Test
    @DisplayName("로또 번호들에 보너스볼이 일치하는게 있는지 확인한다.")
    void match_test() {
        //given
        LotteryNumbers lotteryNumbers = new LotteryNumbers(List.of(1, 2, 3, 4, 5, 45));
        BonusBall bonusBall = new BonusBall(5);

        //when
        boolean match = bonusBall.match(lotteryNumbers);

        assertThat(match).isEqualTo(true);
    }
}
