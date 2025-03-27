package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    public void 구매한_전체_로또의_당첨_결과를_반환한다() {
        Lotto winningLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        Lotto firstRankLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto thirdRankLotto = Lotto.of(List.of(1, 2, 3, 4, 10, 20));
        Lotto noPrizeRankLotto = Lotto.of(List.of(1, 2, 11, 23, 33, 38));
        List<Lotto> lottoList = List.of(firstRankLotto, thirdRankLotto, noPrizeRankLotto);

        Map<Rank, Integer> lottoStatistics = LottoResult.analyzeLottoStatistics(lottoList, winningLotto);

        assertThat(lottoStatistics.get(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoStatistics.get(Rank.SECOND)).isEqualTo(0);
        assertThat(lottoStatistics.get(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoStatistics.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(lottoStatistics.get(Rank.NO_PRIZE)).isEqualTo(1);
    }

    @Test
    public void 구매한_로또의_당첨통계와_구입금액_기반으로_수익률_반환() {
        int purchaseAmount = 3000;

        Lotto firstRankLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto thirdRankLotto = Lotto.of(List.of(1, 2, 3, 4, 10, 20));
        Lotto noPrizeRankLotto = Lotto.of(List.of(1, 2, 11, 23, 33, 38));
        List<Lotto> lottoList = List.of(firstRankLotto, thirdRankLotto, noPrizeRankLotto);

        Customer customer = new Customer(purchaseAmount, lottoList);

        Lotto winningLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        LottoResult lottoResult = LottoResult.of(customer, winningLotto);
        double actual = lottoResult.getROI();
        double expected = (double) (Rank.FIRST.getPrize() + Rank.THIRD.getPrize() + Rank.NO_PRIZE.getPrize()) / purchaseAmount;

        assertThat(actual).isEqualTo(expected);
    }

}
