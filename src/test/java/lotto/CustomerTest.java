package lotto;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {
    @Test
    public void 구매한_로또의_당첨통계와_구입금액_기반으로_수익률_반환() {
        Lotto thirdRankLotto = new Lotto(Rank.THIRD);
        Lotto noPrizeRankLotto = new Lotto(Rank.NO_PRIZE);

        int purchaseAmount = 10000;
        Customer customer = new Customer(10000);

        List<Lotto> lottos = List.of(thirdRankLotto, thirdRankLotto, noPrizeRankLotto); // 3등x2, 꽝x1
        customer.purchaseLottos(lottos);

        double actual = customer.calculateROI();
        double expected = (double) lottos.stream().mapToInt(Lotto::getPrize).sum() / purchaseAmount;

        assertThat(actual).isEqualTo(expected);
    }

}
