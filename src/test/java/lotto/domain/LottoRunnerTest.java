package lotto.domain;

import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoBundle;
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
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
        Lotto second = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16), bonusNumber);
        Lotto third = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16), differentBonusNumber);
        Lotto fail = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16), bonusNumber);

        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(second, third, fail, fail));

        // when
        LottoGameResult lottoGameResult = LottoRunner.runLotto(winner, lottoBundle);
        LottoWinResult lottoWinResult = lottoGameResult.getLottoWinResult();

        // then
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.FIRST)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(lottoWinResult.getLottoRankCount(LottoRank.FAIL)).isEqualTo(2);
    }

    @Test
    public void 로또_실행_후_총_이익률_가져오기() {
        // given
        int bonusNumber = 45;
        int differentBonusNumber = 44;
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
        Lotto second = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16), bonusNumber);
        Lotto third = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16), differentBonusNumber);
        Lotto fail = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16), bonusNumber);

        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(second, third, fail, fail));

        // when
        LottoGameResult lottoGameResult = LottoRunner.runLotto(winner, lottoBundle);
        double totalProfitRate = lottoGameResult.getTotalProfitRate();

        // then
        int realNumberOfLottos = lottoBundle.getLottos().size();
        long realCost = LottoMachine.LOTTO_PRICE * realNumberOfLottos;
        long realTotalPrizeMoney = LottoRank.SECOND.getPrizeMoney() + LottoRank.THIRD.getPrizeMoney();

        assertThat(totalProfitRate).isEqualTo(realTotalPrizeMoney / realCost);
    }

}
