package lotto;

import lotto.domain.LottoRank;
import lotto.domain.MatchResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @DisplayName("같은 번호 개수로 enum 찾기")
    @Test
    public void findByMatchCount() throws Exception {
        Assertions.assertThat(LottoRank.valueOfMatchCount(new MatchResult(1, false)))
                .isEqualTo(LottoRank.ETC);

        Assertions.assertThat(LottoRank.valueOfMatchCount(new MatchResult(2, true)))
                .isEqualTo(LottoRank.ETC);

        Assertions.assertThat(LottoRank.valueOfMatchCount(new MatchResult(3, false)))
                .isEqualTo(LottoRank.FIFTH);

        Assertions.assertThat(LottoRank.valueOfMatchCount(new MatchResult(3, true)))
                .isEqualTo(LottoRank.FIFTH);

        Assertions.assertThat(LottoRank.valueOfMatchCount(new MatchResult(4, true)))
                .isEqualTo(LottoRank.FOURTH);

        Assertions.assertThat(LottoRank.valueOfMatchCount(new MatchResult(4, false)))
                .isEqualTo(LottoRank.FOURTH);

        Assertions.assertThat(LottoRank.valueOfMatchCount(new MatchResult(5, false)))
                .isEqualTo(LottoRank.THIRD);

        Assertions.assertThat(LottoRank.valueOfMatchCount(new MatchResult(5, true)))
                .isEqualTo(LottoRank.SECOND);

        Assertions.assertThat(LottoRank.valueOfMatchCount(new MatchResult(6, false)))
                .isEqualTo(LottoRank.FIRST);
    }
}