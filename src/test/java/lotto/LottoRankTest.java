package lotto;

import lotto.domain.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @DisplayName("같은 번호 개수로 enum 찾기")
    @Test
    public void findByMatchCount() throws Exception {
        Assertions.assertThat(LottoRank.valueOfMatchCount(1))
                .isEqualTo(LottoRank.ETC);

        Assertions.assertThat(LottoRank.valueOfMatchCount(2))
                .isEqualTo(LottoRank.ETC);

        Assertions.assertThat(LottoRank.valueOfMatchCount(3))
                .isEqualTo(LottoRank.FOURTH);

        Assertions.assertThat(LottoRank.valueOfMatchCount(4))
                .isEqualTo(LottoRank.THIRD);

        Assertions.assertThat(LottoRank.valueOfMatchCount(5))
                .isEqualTo(LottoRank.SECOND);

        Assertions.assertThat(LottoRank.valueOfMatchCount(6))
                .isEqualTo(LottoRank.FIRST);
    }
}