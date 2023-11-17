package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import lotto.domain.Match;
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
    void 당첨_여부_확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        new LottoCenter().matchWinningNumber(lottos, winningNumbers);
        Match matchResult = lottos.get(0).getMatch();

        assertThat(matchResult).isEqualTo(Match.THREEMATCH);
    }

    @Test
    void 통계_당첨_결과() {
        LottoCenter lottoCenter = new LottoCenter();
        int cash = 1000;
        List<Lotto> lottos = lottoCenter.buyLotto(cash);

        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoCenter.matchWinningNumber(lottos, winningNumber);

        List<Long> result = lottoCenter.checkWinningResult(lottos);
        float rate = lottoCenter.checkWinningRate();

        assertThat(result.get(0)).isLessThanOrEqualTo(1);
        assertThat(rate).isLessThanOrEqualTo(1);
    }

}