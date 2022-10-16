package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoRewardTest {

    @DisplayName("등수에 따른 상금을 반환한다.")
    @Test
    void reward() {
        assertThat(LottoReward.reward(2)).isEqualTo(30_000_000);
    }
}
