package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import org.junit.jupiter.api.Test;

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

}