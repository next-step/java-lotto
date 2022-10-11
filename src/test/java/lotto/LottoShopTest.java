package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoShopTest {

    @Test
    void 제공한_금액만큼_로또를_제공() {
        LottoShop shop = new LottoShop();
        Lottos lottos = shop.buy(new Money(2000));
        Assertions.assertThat(lottos).isEqualTo(
            new Lottos(
                List.of(
                    new Lotto(),
                    new Lotto()
                )
            )
        );
    }
}
