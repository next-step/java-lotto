package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class LottoSellerTest {

    @Test
    @DisplayName("장당 1000원에 로또를 구매한다")
    public void 로또_구매Test() {
        Money money = new Money(2000);

        Lottos lottos = LottoSeller.sell(money, new RandomLottoNumberStrategy());

        assertThat(lottos.count()).isEqualTo(2);
    }
}