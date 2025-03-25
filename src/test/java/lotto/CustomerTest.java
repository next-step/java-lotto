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

        int purchaseAmount = 3000;
        List<Lotto> purchaseLotto = List.of(thirdRankLotto, thirdRankLotto, noPrizeRankLotto); // 3등x2, 꽝x1
        Customer customer = new Customer(3000, purchaseLotto);

        double actual = customer.calculateROI();
        double expected = (double) purchaseLotto.stream().mapToInt(Lotto::getPrize).sum() / purchaseAmount;

        assertThat(actual).isEqualTo(expected);
    }

}
