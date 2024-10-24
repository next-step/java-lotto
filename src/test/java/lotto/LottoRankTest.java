package lotto;

import lotto.service.LottoRank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoRankTest {

    @Test
    public void 번호_일치_개수에_따른_등수() {

        assertThat(LottoRank.getRankByMatchCount(6, false)).isEqualTo(1);
        assertThat(LottoRank.getRankByMatchCount(6, true)).isEqualTo(2);

        for (int matchCount = 5, rank = 3; matchCount >= 3; matchCount--, rank++) {
            assertThat(LottoRank.getRankByMatchCount(matchCount, false)).isEqualTo(rank);
        }

        for (int matchCount = 5, rank = 4; matchCount >= 4; matchCount--, rank++) {
            assertThat(LottoRank.getRankByMatchCount(matchCount, true)).isEqualTo(rank);
        }

        for (int matchCount = 2; matchCount >= 0; matchCount--) {
            assertThat(LottoRank.getRankByMatchCount(matchCount, false)).isEqualTo(0);
        }

        for (int matchCount = 3; matchCount >= 0; matchCount--) {
            assertThat(LottoRank.getRankByMatchCount(matchCount, true)).isEqualTo(0);
        }
    }

}
