package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRewardsTest {
    @Test
    void 당첨_테스트() {
        assertThat(LottoRewards.from(6, false)).isEqualTo(LottoRewards.FIRST);
        assertThat(LottoRewards.from(5, true)).isEqualTo(LottoRewards.SECOND);
        assertThat(LottoRewards.from(5, false)).isEqualTo(LottoRewards.THIRD);
    }

}