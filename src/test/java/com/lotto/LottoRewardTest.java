package com.lotto;

import org.junit.jupiter.api.Test;

import static com.lotto.domain.LottoReward.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRewardTest {
    @Test
    void 로또보상_생성() {
        assertThat(generateReward(1)).isEqualTo(NOTHING);
        assertThat(generateReward(2)).isEqualTo(NOTHING);
        assertThat(generateReward(3)).isEqualTo(THREE);
        assertThat(generateReward(4)).isEqualTo(FOUR);
        assertThat(generateReward(5)).isEqualTo(FIVE);
        assertThat(generateReward(6)).isEqualTo(SIX);
        assertThat(generateReward(7)).isEqualTo(NOTHING);
    }

    @Test
    void 로또_총_보상금() {
        assertThat(THREE.totalReward(3)).isEqualTo(5000 * 3);
        assertThat(NOTHING.totalReward(3)).isEqualTo(0);
    }
}
