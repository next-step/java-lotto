package com.lotto;

import org.junit.jupiter.api.Test;

import static com.lotto.domain.LottoReward.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRewardTest {
    @Test
    void 로또보상_생성() {
        assertThat(generateReward(1)).isEqualTo(MISS);
        assertThat(generateReward(2)).isEqualTo(MISS);
        assertThat(generateReward(3)).isEqualTo(FOURTH);
        assertThat(generateReward(4)).isEqualTo(THIRD);
        assertThat(generateReward(5)).isEqualTo(SECOND);
        assertThat(generateReward(6)).isEqualTo(FIRST);
        assertThat(generateReward(7)).isEqualTo(MISS);
    }

    @Test
    void 로또_총_보상금() {
        assertThat(FOURTH.totalReward(3)).isEqualTo(5000 * 3);
        assertThat(MISS.totalReward(3)).isEqualTo(0);
    }
}
