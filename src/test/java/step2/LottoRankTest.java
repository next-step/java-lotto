package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    public void 당첨_개수에_따른_LottoRank_반환_테스트() {
        assertThat(LottoRank.evaluateLottoRankByMatchCount(6)).isEqualTo(LottoRank.FIRST_PRIZE);
        assertThat(LottoRank.evaluateLottoRankByMatchCount(3)).isEqualTo(LottoRank.FOURTH_PRIZE);
        assertThat(LottoRank.evaluateLottoRankByMatchCount(2)).isEqualTo(LottoRank.NO_PRIZE);
        assertThat(LottoRank.evaluateLottoRankByMatchCount(0)).isEqualTo(LottoRank.NO_PRIZE);
    }
}
