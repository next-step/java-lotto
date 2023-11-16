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
        List<Lotto> lottos = new LottoCenter().generateTicket(buyCount);
        System.out.println("lottos.get(0) = " + lottos.get(0).selectedNumber());
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Lotto> checkedLotteries = new LottoCenter().matchWinningNumber(lottos, winningNumber);
        int result = checkedLotteries.get(0).getMatchCount();

        assertThat(result).isLessThanOrEqualTo(6);
    }

}