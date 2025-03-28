package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.domain.LottoNumber.convertToLottoNumber;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    public void 구매한_전체_로또의_당첨_결과를_반환한다_보너스볼판단포함() {
        WinningLotto winningLotto = new WinningLotto(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 6)), 7);

        Lotto firstRankLotto = Lotto.of(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 6)));
        Lotto secondRankLotto = Lotto.of(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 7)));
        Lotto thirdRankLotto = Lotto.of(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 38)));
        List<Lotto> lottoList = List.of(firstRankLotto, secondRankLotto, thirdRankLotto);

        Map<Rank, Integer> lottoStatistics = LottoResult.analyzeLottoStatistics(lottoList, winningLotto);

        assertThat(lottoStatistics.get(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoStatistics.get(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoStatistics.get(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoStatistics.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(lottoStatistics.get(Rank.NO_PRIZE)).isEqualTo(0);
    }

    @Test
    public void 구매한_로또의_당첨통계와_구입금액_기반으로_수익률_반환_보너스볼판단포함() {
        int purchaseAmount = 3000;

        Lotto firstRankLotto = Lotto.of(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 6)));
        Lotto secondRankLotto = Lotto.of(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 7)));
        Lotto thirdRankLotto = Lotto.of(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 38)));
        List<Lotto> lottoList = List.of(firstRankLotto, secondRankLotto, thirdRankLotto);

        Customer customer = new Customer(purchaseAmount, lottoList);

        WinningLotto winningLotto = new WinningLotto(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 6)), 7);

        LottoResult lottoResult = LottoResult.of(customer, winningLotto);
        double actual = lottoResult.getROI();
        double expected = (double) (Rank.FIRST.getPrize() + Rank.SECOND.getPrize() + Rank.THIRD.getPrize()) / purchaseAmount;

        assertThat(actual).isEqualTo(expected);
    }

}
