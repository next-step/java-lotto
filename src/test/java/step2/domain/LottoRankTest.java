package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void 상금테스트_1등() {
        assertThat(LottoRank.countOfMatchNumber(6, false).getReward())
                .isEqualTo(2000000000);
    }

    @Test
    void 상금테스트_2등() {
        assertThat(LottoRank.countOfMatchNumber(5, true).getReward())
                .isEqualTo(30000000);
    }

    @Test
    void 상금테스트_3등() {
        assertThat(LottoRank.countOfMatchNumber(5, false).getReward())
                .isEqualTo(1500000);
    }

    @Test
    void 상금테스트_4등() {
        assertThat(LottoRank.countOfMatchNumber(4, false).getReward())
                .isEqualTo(50000);
    }

    @Test
    void 상금테스트_5등() {
        assertThat(LottoRank.countOfMatchNumber(3, false).getReward())
                .isEqualTo(5000);
    }

    @Test
    void 상금테스트_MISS() {
        assertThat(LottoRank.countOfMatchNumber(1, false).getReward())
                .isEqualTo(0);
    }
}