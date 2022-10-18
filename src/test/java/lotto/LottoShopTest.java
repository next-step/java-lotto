package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoShopTest {

    @Test
    void 제공한_금액만큼_로또를_제공() {
        LottoNumberStrategy lottoNumberStrategy = () -> Number.of(1, 2);
        LottoShop shop = new LottoShop(lottoNumberStrategy);
        Lottos lottos = shop.buy(new Money(2000));
        Assertions.assertThat(lottos).isEqualTo(new Lottos(List.of(new Lotto(Number.of(1, 2)), new Lotto(Number.of(1, 2)))));
    }
}
