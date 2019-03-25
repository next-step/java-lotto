package lotto.vo;

import lotto.enums.LottoRank;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinResultTest {
    @Test
    public void 당첨번호와_비교한_결과를_통해_로또당첨결과_생성() {
        // given
        List<LottoRank> lottoRanks =
                Arrays.asList(LottoRank.FIRST, LottoRank.THIRD, LottoRank.FAIL, LottoRank.FAIL);

        // when
        LottoWinResult lottoWinResult = new LottoWinResult(lottoRanks);

        // then
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.SECOND)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.FAIL)).isEqualTo(2);
    }
}
