package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoCenterTest {

    @Test
    void 로또_구매_수량() {
        int cash = 14000;
        int number = new LottoCenter().buyLotto(cash);

        assertThat(number).isEqualTo(14);
    }

    @Test
    void 로또_생성() {
        int buyCount = 1;
        List<Lotto> issuedTicket = new LottoCenter().generateTicket(buyCount);
        List<Integer> numbers = issuedTicket.get(0).selectedNumber();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 당첨_여부_확인() {
        int buyCount = 1;
        LottoCenter lottoCenter = new LottoCenter();
        List<Lotto> lottos = lottoCenter.generateTicket(buyCount);
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        lottoCenter.matchWinningNumber(lottos, winningNumber);
        int result = lottos.get(0).getMatchCount();

        assertThat(result).isLessThanOrEqualTo(6);
    }

    @Test
    void 통계_당첨_결과() {
        LottoCenter lottoCenter = new LottoCenter();
        int cash = 1000;
        int buyCount = lottoCenter.buyLotto(cash);
        List<Lotto> lottos = lottoCenter.generateTicket(buyCount);

        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoCenter.matchWinningNumber(lottos, winning);

        List<Long> result = lottoCenter.checkWinningResult(lottos);
        float rate = lottoCenter.checkWinningRate();

        assertThat(result.get(0)).isLessThanOrEqualTo(1);
        assertThat(rate).isLessThanOrEqualTo(1);
    }

}