package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankWithWinningCountTest {

    @Test
    @DisplayName("해당 랭킹에 맞는 당첨횟수를 가지는지 테스트")
    void rankWithWinningCount_getWinningCount() {
        List<LottoRank> lottoRanks = List.of(LottoRank.FIFTH, LottoRank.NONE, LottoRank.SECOND);

        RankWithWinningCount rankWithWinningCount = new RankWithWinningCount(lottoRanks);

        assertThat(rankWithWinningCount.getWinningCount(LottoRank.FIRST)).isEqualTo(0);
        assertThat(rankWithWinningCount.getWinningCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(rankWithWinningCount.getWinningCount(LottoRank.THIRD)).isEqualTo(0);
        assertThat(rankWithWinningCount.getWinningCount(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(rankWithWinningCount.getWinningCount(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(rankWithWinningCount.getWinningCount(LottoRank.NONE)).isEqualTo(1);
    }
}