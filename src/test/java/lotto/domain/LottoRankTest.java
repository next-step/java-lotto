package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoRankTest {

    @Test
    void 일치하는_숫자_개수에_따른_등수_반환() {
        assertThat(LottoRank.findRankByMatchCount(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.findRankByMatchCount(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.findRankByMatchCount(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.findRankByMatchCount(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.findRankByMatchCount(4, true)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.findRankByMatchCount(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.findRankByMatchCount(3, true)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.findRankByMatchCount(2, false)).isEqualTo(LottoRank.ETC);
        assertThat(LottoRank.findRankByMatchCount(1, false)).isEqualTo(LottoRank.ETC);
        assertThat(LottoRank.findRankByMatchCount(0, false)).isEqualTo(LottoRank.ETC);
    }

    @Test
    void 일치하는_개수_유효성_검사_최솟값() {
        assertThatThrownBy(() -> {
            LottoRank.findRankByMatchCount(-1, true);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 일치하는_개수_유효성_검사_최댓값() {
        assertThatThrownBy(() -> {
            LottoRank.findRankByMatchCount(7, true);
        }).isInstanceOf(RuntimeException.class);
    }
}