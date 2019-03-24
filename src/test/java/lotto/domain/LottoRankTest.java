package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    public void 일등구하기() {
        LottoRank lottoRank = LottoRank.valueOf(6, false);
        assertThat(lottoRank.matchCount).isEqualTo(6);
    }

    @Test
    public void 보너스Rank_구하기() {
        LottoRank lottoRank = LottoRank.valueOf(5, true);
        assertThat(lottoRank.matchCount).isEqualTo(5);
    }
}
