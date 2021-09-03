package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @DisplayName("1등 테스트")
    @Test
    void first() {
        assertThat(LottoRank.findRank(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("2등 테스트")
    @Test
    void second() {
        assertThat(LottoRank.findRank(5, true)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("3등 테스트")
    @Test
    void third() {
        assertThat(LottoRank.findRank(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4등 테스트")
    @Test
    void fourth() {
        assertThat(LottoRank.findRank(4, false)).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("5등 테스트")
    @Test
    void fifth() {
        assertThat(LottoRank.findRank(3, false)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("미당첨 테스트")
    @Test
    void fail() {
        assertThat(LottoRank.findRank(0, false)).isEqualTo(LottoRank.FAIL);
        assertThat(LottoRank.findRank(1, false)).isEqualTo(LottoRank.FAIL);
        assertThat(LottoRank.findRank(2, false)).isEqualTo(LottoRank.FAIL);
    }


}
