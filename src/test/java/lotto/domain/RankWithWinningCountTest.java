package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankWithWinningCountTest {

    @Test
    @DisplayName("해당 랭킹에 맞는 당첨횟수를 가지는지 테스트")
    void rankWithWinningCount_getWinningCount() {
        List<LottoRule> lottoRules = List.of(LottoRule.FIFTH, LottoRule.NONE, LottoRule.SECOND);

        RankWithWinningCount rankWithWinningCount = new RankWithWinningCount(lottoRules);

        assertThat(rankWithWinningCount.getWinningCount(LottoRule.FIRST)).isEqualTo(0);
        assertThat(rankWithWinningCount.getWinningCount(LottoRule.SECOND)).isEqualTo(1);
        assertThat(rankWithWinningCount.getWinningCount(LottoRule.THIRD)).isEqualTo(0);
        assertThat(rankWithWinningCount.getWinningCount(LottoRule.FOURTH)).isEqualTo(0);
        assertThat(rankWithWinningCount.getWinningCount(LottoRule.FIFTH)).isEqualTo(1);
        assertThat(rankWithWinningCount.getWinningCount(LottoRule.NONE)).isEqualTo(1);
    }
}