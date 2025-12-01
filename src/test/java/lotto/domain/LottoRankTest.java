package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @Test
    void 매칭된_숫자로_랭크_구하기() {
        LottoRank lottoRank = LottoRank.getLottoRank(3, false);

        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 매칭된_숫자_보너스_숫자로_랭크_구하기() {
        LottoRank lottoRank = LottoRank.getLottoRank(5, false);

        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }
}
