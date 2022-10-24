package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoShopTest {

    @Test
    void 제공한_금액만큼_로또를_제공() {
        LottoNumberStrategy lottoNumberStrategy = () -> lotto.domain.Number.of(1, 2, 3, 4, 5, 6);
        LottoShop shop = new LottoShop(lottoNumberStrategy, new Money(2000), 0);
        Lottos lottos = shop.buy();
        Assertions.assertThat(lottos).isEqualTo(new Lottos(List.of(new Lotto(lotto.domain.Number.of(1, 2, 3, 4, 5, 6)), new Lotto(Number.of(1, 2, 3, 4, 5, 6)))));
    }

    @Test
    void 자동_구매분_계산(){
        LottoNumberStrategy lottoNumberStrategy = () -> lotto.domain.Number.of(1, 2, 3, 4, 5, 6);
        LottoShop shop = new LottoShop(lottoNumberStrategy, new Money(14000), 3);
        Assertions.assertThat(shop.numberOfPurchasingAuto()).isEqualTo(11);
    }

    @Test
    void 수동_구입분이_입력가격보다_크면_에러_발생(){
        LottoNumberStrategy lottoNumberStrategy = () -> lotto.domain.Number.of(1, 2, 3, 4, 5, 6);
        Assertions.assertThatThrownBy(() -> new LottoShop(lottoNumberStrategy, new Money(14000), 15))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동 구입분이 입력 금액을 초과 했습니다.");
    }

    @Test
    void 수동_구입분_번호_입력받아서_로또_구입_구현(){
        LottoNumberStrategy lottoNumberStrategy = () -> lotto.domain.Number.of(1, 2, 3, 4, 5, 6);
        LottoShop shop = new LottoShop(lottoNumberStrategy, new Money(14000), 3);
        shop.buyManually(Number.of(1, 2, 3, 4, 5, 6));
        shop.buyManually(Number.of(2, 3, 4, 5, 6, 7));
        shop.buyManually(Number.of(3, 4, 5, 6, 7, 8));

        Lottos lottos = shop.buy();

        Assertions.assertThat(lottos.getLottos())
            .hasSize(14)
            .containsAll(
                List.of(
                    new Lotto(Number.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(Number.of(2, 3, 4, 5, 6, 7)),
                    new Lotto(Number.of(3, 4, 5, 6, 7, 8))
                )
            );
    }

    @Test
    void 수동구매_가능여부_확인(){
        LottoNumberStrategy lottoNumberStrategy = () -> lotto.domain.Number.of(1, 2, 3, 4, 5, 6);
        LottoShop shop = new LottoShop(lottoNumberStrategy, new Money(14000), 3);
        shop.buyManually(Number.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(shop.possibleBuyManually()).isTrue();

        shop.buyManually(Number.of(1, 2, 3, 4, 5, 6));
        shop.buyManually(Number.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(shop.possibleBuyManually()).isFalse();
    }

    @Test
    void 수동구매_가능횟수_초과시_에러발생(){
        LottoNumberStrategy lottoNumberStrategy = () -> lotto.domain.Number.of(1, 2, 3, 4, 5, 6);
        LottoShop shop = new LottoShop(lottoNumberStrategy, new Money(14000), 3);
        shop.buyManually(Number.of(1, 2, 3, 4, 5, 6));
        shop.buyManually(Number.of(1, 2, 3, 4, 5, 6));
        shop.buyManually(Number.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThatThrownBy(() -> shop.buyManually(Number.of(1, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동 구입가능 횟수를 초과 하였습니다.");
    }
}
