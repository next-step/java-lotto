package lotto.domain;

import lotto.enums.LottoRank;
import lotto.vo.LottoGameResult;
import lotto.vo.LottoWinResult;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRunnerTest {
    @Test
    public void 로또_실행_후_당첨_결과_가져오기() {
        // given
        int bonusNumber = 45;
        int differentBonusNumber = 44;
        WinningLotto winner = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
        Lotto second = new Lotto(Arrays.asList(1, 2, 3, 4, 5, bonusNumber));
        Lotto third = new Lotto(Arrays.asList(1, 2, 3, 4, 5, differentBonusNumber));
        Lotto fail = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));

        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(second, third, fail, fail));

        // when
        LottoGameResult lottoGameResult = LottoRunner.runLotto(winner, lottoBundle);
        LottoWinResult lottoWinResult = lottoGameResult.getLottoWinResult();

        // then
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.FIRST)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCountOf(LottoRank.FAIL)).isEqualTo(2);
    }

    @Test
    public void 로또_실행_후_총_이익률_가져오기() {
        // given
        int bonusNumber = 45;
        int differentBonusNumber = 44;

        WinningLotto winner = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
        Lotto second = new Lotto(Arrays.asList(1, 2, 3, 4, 5, bonusNumber));
        Lotto third = new Lotto(Arrays.asList(1, 2, 3, 4, 5, differentBonusNumber));
        Lotto fail = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));

        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(second, third, fail, fail));

        // when
        LottoGameResult lottoGameResult = LottoRunner.runLotto(winner, lottoBundle);
        double totalProfitRate = lottoGameResult.getTotalProfitRate();

        // then
        int realNumberOfLottos = lottoBundle.getLottos().size();
        long realCost = LottoMachine.LOTTO_PRICE.getAmount() * realNumberOfLottos;
        long realTotalPrizeMoney = LottoRank.SECOND.getPrizeMoney().getAmount() +
                LottoRank.THIRD.getPrizeMoney().getAmount();

        assertThat(totalProfitRate).isEqualTo(realTotalPrizeMoney / realCost);
    }

}
