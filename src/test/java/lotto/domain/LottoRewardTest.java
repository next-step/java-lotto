package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LottoRewardTest {
    @Test
    void 생성_테스트() {
        assertThat(LottoReward.of(0, false)).isEqualTo(LottoReward.MISS);
        assertThat(LottoReward.of(1, false)).isEqualTo(LottoReward.MISS);
        assertThat(LottoReward.of(2, false)).isEqualTo(LottoReward.MISS);
        assertThat(LottoReward.of(3, false)).isEqualTo(LottoReward.FIFTH);
        assertThat(LottoReward.of(4, false)).isEqualTo(LottoReward.FOURTH);
        assertThat(LottoReward.of(5, false)).isEqualTo(LottoReward.THIRD);
        assertThat(LottoReward.of(5, true)).isEqualTo(LottoReward.SECOND);
        assertThat(LottoReward.of(6, false)).isEqualTo(LottoReward.FIRST);
    }
}
