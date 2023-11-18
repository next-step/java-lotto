package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    public void 당첨_개수에_따른_LottoRank_반환_테스트() {
        assertThat(LottoRank.evaluateLottoRankByMatchCount(5, true)).isEqualTo(LottoRank.SECOND_PRIZE);
        assertThat(LottoRank.evaluateLottoRankByMatchCount(5, false)).isEqualTo(LottoRank.THIRD_PRIZE);
        assertThat(LottoRank.evaluateLottoRankByMatchCount(3, true)).isEqualTo(LottoRank.FIFTH_PRIZE);
        assertThat(LottoRank.evaluateLottoRankByMatchCount(3, false)).isEqualTo(LottoRank.FIFTH_PRIZE);
        assertThat(LottoRank.evaluateLottoRankByMatchCount(2, false)).isEqualTo(LottoRank.NO_PRIZE);
        assertThat(LottoRank.evaluateLottoRankByMatchCount(0, false)).isEqualTo(LottoRank.NO_PRIZE);
    }
}
