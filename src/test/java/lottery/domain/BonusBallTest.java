package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BonusBallTest {

    @Test
    @DisplayName("보너스볼은 당첨 번호에 포함되면 안된다.")
    void bonusBall_test() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new BonusBall(new WinnerLottery(new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6))), 3)
        );
    }
}
