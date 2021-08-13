import Lotto.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Lotto.WinningPrice.THREE_WINNINGS;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @Test
    @DisplayName("정산율 통과 테스트")
    void yieldPassTest() {
        WinningResult winningResult = WinningResult.of(List.of(THREE_WINNINGS));
        assertThat(winningResult.yieldAccount(14000)).isEqualTo(0.35);
    }

}
