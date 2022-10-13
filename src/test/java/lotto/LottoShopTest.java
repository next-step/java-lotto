package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoShopTest {

    @Test
    void 제공한_금액만큼_로또를_제공() {
        LottoNumberStrategy lottoNumberStrategy = () -> List.of(16, 15, 14, 13, 12, 11);
        LottoShop shop = new LottoShop(lottoNumberStrategy);
        Lottos lottos = shop.buy(new Money(2000));
        Assertions.assertThat(lottos).isEqualTo(
            new Lottos(
                List.of(
                    new Lotto(List.of(1)),
                    new Lotto(List.of(1))
                )
            )
        );
    }
}
