package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void 상금테스트_1등() {
        assertThat(LottoRank.valueOf(6).getReward())
                .isEqualTo(2000000000);
    }

    @Test
    void 상금테스트_2등() {
        assertThat(LottoRank.valueOf(5).getReward())
                .isEqualTo(1500000);
    }

    @Test
    void 상금테스트_3등() {
        assertThat(LottoRank.valueOf(4).getReward())
                .isEqualTo(50000);
    }

    @Test
    void 상금테스트_4등() {
        assertThat(LottoRank.valueOf(3).getReward())
                .isEqualTo(5000);
    }

    @Test
    void 상금테스트_MISS() {
        assertThat(LottoRank.valueOf(1).getReward())
                .isEqualTo(0);
    }
}