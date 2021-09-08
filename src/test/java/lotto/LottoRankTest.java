package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("유효한 로또 등수들만 가져오는지 테스트")
    void ranks() {
        assertThat(
                LottoRank.ranks().stream().noneMatch(rank -> rank == LottoRank.NONE)
        ).isEqualTo(true);
    }

    @Test
    @DisplayName("해당하는 로또 등수를 가져오는지 테스트")
    void valueOf() {
        assertThat(LottoRank.valueOf(-1, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(0, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(7, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);

    }
}