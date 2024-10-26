package lotto;

import lotto.service.LottoRank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoRankTest {

    @Test
    public void 번호_일치_개수에_따른_등수() {
        assertThat(LottoRank.getRankByMatchCount(6, true)).isEqualTo(1);
        assertThat(LottoRank.getRankByMatchCount(6, false)).isEqualTo(1);

        assertThat(LottoRank.getRankByMatchCount(5, true)).isEqualTo(2);
        assertThat(LottoRank.getRankByMatchCount(5, false)).isEqualTo(3);

        assertThat(LottoRank.getRankByMatchCount(4, true)).isEqualTo(4);
        assertThat(LottoRank.getRankByMatchCount(4, false)).isEqualTo(4);

        assertThat(LottoRank.getRankByMatchCount(3, true)).isEqualTo(5);
        assertThat(LottoRank.getRankByMatchCount(3, false)).isEqualTo(5);

        assertThat(LottoRank.getRankByMatchCount(2, true)).isEqualTo(0);
        assertThat(LottoRank.getRankByMatchCount(2, false)).isEqualTo(0);

        assertThat(LottoRank.getRankByMatchCount(1, true)).isEqualTo(0);
        assertThat(LottoRank.getRankByMatchCount(1, false)).isEqualTo(0);

        assertThat(LottoRank.getRankByMatchCount(0, true)).isEqualTo(0);
        assertThat(LottoRank.getRankByMatchCount(0, false)).isEqualTo(0);
    }

}
