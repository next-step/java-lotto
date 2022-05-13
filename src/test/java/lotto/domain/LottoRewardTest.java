package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LottoRewardTest {
    @Test
    void 생성_테스트() {
        assertThat(LOTTO_REWARD.of(0, false)).isEqualTo(LOTTO_REWARD.MISS);
        assertThat(LOTTO_REWARD.of(1, false)).isEqualTo(LOTTO_REWARD.MISS);
        assertThat(LOTTO_REWARD.of(2, false)).isEqualTo(LOTTO_REWARD.MISS);
        assertThat(LOTTO_REWARD.of(3, false)).isEqualTo(LOTTO_REWARD.FIFTH);
        assertThat(LOTTO_REWARD.of(4, false)).isEqualTo(LOTTO_REWARD.FOURTH);
        assertThat(LOTTO_REWARD.of(5, false)).isEqualTo(LOTTO_REWARD.THIRD);
        assertThat(LOTTO_REWARD.of(5, true)).isEqualTo(LOTTO_REWARD.SECOND);
        assertThat(LOTTO_REWARD.of(6, false)).isEqualTo(LOTTO_REWARD.FIRST);
    }
}
