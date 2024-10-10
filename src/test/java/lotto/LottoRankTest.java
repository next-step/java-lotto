package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @Test
    void 당첨_등수_구하기() {
        // given
        int equalNumberCount = 6;

        // when
        LottoRank lottoRank = LottoRank.fromEqualNumberCount(equalNumberCount);

        // then
        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 당첨_액수_구하기() {
        // given
        int equalNumberCount = 6;

        // when
        int prizeMoneyAmount = LottoRank.findPrizeMoneyFromEqualNumberCount(equalNumberCount);

        // then
        Assertions.assertThat(prizeMoneyAmount).isEqualTo(LottoRank.FIRST.prizeMoneyAmount);
    }
}
