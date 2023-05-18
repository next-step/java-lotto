package lotto.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningCountTest {

    @Test
    @DisplayName("상금이 없는 경우")
    void none_reward() {
        WinningCount winningCount = WinningCount.NONE;

        assertThat(WinningCount.isRewardWinningCount(winningCount)).isFalse();
    }
}
