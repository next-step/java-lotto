package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.LottoNumberConverter.toLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {


    @Test
    public void 구매한_로또의_당첨통계와_구입금액_기반으로_수익률_반환_보너스볼판단포함() {
        int purchaseAmount = 3000;

        Lotto firstRankLotto = Lotto.generateManualLotto(LottoNumber.from(List.of(1, 2, 3, 4, 5, 6)));
        Lotto secondRankLotto = Lotto.generateManualLotto(LottoNumber.from(List.of(1, 2, 3, 4, 5, 7)));
        Lotto thirdRankLotto = Lotto.generateManualLotto(LottoNumber.from(List.of(1, 2, 3, 4, 5, 38)));
        List<Lotto> lottoList = List.of(firstRankLotto, secondRankLotto, thirdRankLotto);

        Customer customer = new Customer(purchaseAmount, new Lottos(lottoList));

        WinningLotto winningLotto = new WinningLotto(toLottoNumbers(List.of(1, 2, 3, 4, 5, 6)), 7);

        LottoResult lottoResult = LottoResult.of(customer, winningLotto);
        double actual = lottoResult.getROI();
        double expected = (double) (Rank.FIRST.getPrize() + Rank.SECOND.getPrize() + Rank.THIRD.getPrize()) / purchaseAmount;

        assertThat(actual).isEqualTo(expected);
    }

}
