package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000})
    public void 입력한_금액만큼_로또를_구매한다(int amount) {
        Lottos lottos = LottoShop.sellAutoLottos(amount);

        int actual = lottos.countAllLotto();
        int expected = LottoShop.calculateLottoCount(amount);
        assertThat(actual).isEqualTo(expected);
    }

}
