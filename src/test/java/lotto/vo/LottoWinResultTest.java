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
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.SECOND)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.FAIL)).isEqualTo(2);
    }
}
