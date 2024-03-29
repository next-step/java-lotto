package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class LottoSellerTest {

    @Test
    @DisplayName("장당 1000원에 로또를 구매한다")
    public void 로또_구매Test() {
        Money money = new Money(2000);

        Lottos lottos = LottoSeller.sell(BuyAutoLotto.create(money, 2));

        assertThat(lottos.count()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 번호 수동으로 구매")
    public void buyManualLottoNumberTest() {
        BuyLotto buyLotto = BuyManualLotto.create(new Money(1000), 1, List.of(List.of(1, 2, 3, 4, 5, 6)));

        Lottos sut = LottoSeller.sell(buyLotto);

        assertThat(sut.count()).isEqualTo(1);
        assertThat(sut.getLottos()).containsExactly(new Lotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6))));
    }

    @Test
    @DisplayName("로또 번호 수동, 자동 1매씩 구매")
    public void butAutoAndManualLottoTest() {
        BuyLotto autoLotto = BuyAutoLotto.create(new Money(1000), 1);
        BuyLotto manualLotto = BuyManualLotto.create(
                new Money(1000),
                1,
                List.of(List.of(1, 2, 3, 4, 5, 6))
        );

        Lottos manual = LottoSeller.sell(manualLotto);
        Lottos sut = LottoSeller.sell(autoLotto);
        sut.merge(manual.getLottos());

        assertThat(sut.count()).isEqualTo(2);
        assertThat(sut.getLottos()).contains(new Lotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6))));
    }


    @Test
    @DisplayName("돈 부족하면 구매 실패한다")
    public void failIfMoneyNotSufficient() {
        BuyLotto buyLotto = BuyAutoLotto.create(new Money(2000), 1000);
        Assertions.assertThrows(IllegalStateException.class, () -> LottoSeller.sell(buyLotto));
    }
}