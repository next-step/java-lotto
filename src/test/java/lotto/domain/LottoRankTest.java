package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    public void 일등구하기() {
        LottoRank lottoRank = LottoRank.valueOf(1, false);
        assertThat(lottoRank.number).isEqualTo(1);
    }

    @Test
    public void 보너스Rank_구하기() {
        LottoRank lottoRank = LottoRank.valueOf(2, true);
        assertThat(lottoRank.number).isEqualTo(2);
    }
}
