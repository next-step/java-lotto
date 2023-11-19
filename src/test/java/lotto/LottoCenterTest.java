package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoCenterTest {

    @Test
    void 로또_구매() {
        int cash = 14000;
        List<Lotto> lottos = new LottoCenter().buyLotto(cash);

        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    void 로또_생성() {
        int cash = 14000;
        List<Lotto> issuedTicket = new LottoCenter().buyLotto(cash);
        List<Integer> numbers = issuedTicket.get(0).getNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 당첨_여부_확인_5등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        new LottoCenter().matchWinningNumbers(lottos, winningNumbers, bonusNumber);
        Rank rank = lottos.get(0).getRank();

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 당첨_여부_확인_2등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 9;

        new LottoCenter().matchWinningNumbers(lottos, winningNumbers, bonusNumber);
        Rank rank = lottos.get(0).getRank();

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 통계_당첨_결과() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        LottoCenter lottoCenter = new LottoCenter();
        lottoCenter.matchWinningNumbers(lottos, winningNumber, bonusNumber);

        List<Long> result = lottoCenter.checkWinningResult(lottos);

        assertThat(result.get(0)).isEqualTo(0);
        assertThat(result.get(2)).isEqualTo(1);
    }

    @Test
    void 통계_당첨_수익률() {
        int cash = 1000;
        LottoCenter lottoCenter = new LottoCenter();
        List<Lotto> lottos = lottoCenter.buyLotto(cash);

        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        lottoCenter.matchWinningNumbers(lottos, winningNumber, bonusNumber);
        lottoCenter.checkWinningResult(lottos);

        float rate = lottoCenter.checkWinningRate();

        assertThat(rate).isLessThanOrEqualTo(1);
    }
}