package lotto;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CustomerTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -100, -1000})
    public void 구입금액이_0이하인경우_예외가_발생한다(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Customer().purchaseLottos(amount));
    }

    @Test
    public void 구매한_로또의_당첨통계와_구입금액_기반으로_수익률_반환() {
        Lotto thirdRankLotto = new Lotto(Rank.THIRD);
        Lotto noPrizeRankLotto = new Lotto(Rank.NO_PRIZE);

        int purchaseAmount = 3000;
        Lottos lottos = new Lottos(List.of(thirdRankLotto, thirdRankLotto, noPrizeRankLotto)); // 3등x2, 꽝x1
        Customer customer = new Customer(3000, lottos);

        double actual = customer.calculateROI();
        double expected = (double) lottos.getLottoList().stream().mapToInt(Lotto::getPrize).sum() / purchaseAmount;

        assertThat(actual).isEqualTo(expected);
    }

}
