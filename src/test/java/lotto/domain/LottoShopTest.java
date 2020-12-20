package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoShopTest {
    @Test
    @DisplayName("천원으로 자동 로또 한장 구매")
    void generateLottos() {
        LottoShop shop = new LottoShop(1000, 0);

        Lottos lottos = shop.getAutoLottos();
        assertThat(lottos.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("천원으로 수동로또 한장 구매")
    void generate_manual_lotto_test() {
        LottoShop shop = new LottoShop(1000, 1);
        List<Lotto> manualLottos = Arrays.asList(
                Lotto.of(Arrays.asList(2, 3, 5, 6, 33, 40))
        );
        Lottos purchasedLotto = shop.getManualLottos(manualLottos);
        assertThat(purchasedLotto.size()).isEqualTo(1);
        assertThat(purchasedLotto.getLottos().contains(
                Lotto.of(Arrays.asList(2, 3, 5, 6, 33, 40))
        )).isTrue();
    }

    @Test
    @DisplayName("1000원보다 적을 경우 notEnoughMoneyException")
    void under_lotto_price_test() {
        assertThatThrownBy(() -> new LottoShop(700, 2))
                .isInstanceOf(NotEnoughLottoPurchaseMoneyException.class)
                .hasMessage("구매금액이 부족합니다.");
    }

    @Test
    @DisplayName("1000원으로 수동로또 2장 주문하려고 하면 notEnoughMoneyException")
    void notEnoughMoneyException_manual_test() {
        assertThatThrownBy(() -> new LottoShop(1000, 2))
                .isInstanceOf(NotEnoughLottoPurchaseMoneyException.class)
                .hasMessage("구매금액이 부족합니다.");
    }

    @Test
    @DisplayName("2000원으로 수동로또 2장 주문하고 자동로또 주문하려고 하면 notEnoughMoneyException")
    void notEnoughMoneyException_auto_test() {
        LottoShop lottoShop = new LottoShop(2000, 2);
        assertThatThrownBy(lottoShop::getAutoLottos)
                .isInstanceOf(NotEnoughLottoPurchaseMoneyException.class)
                .hasMessage("구매금액이 부족합니다.");
    }
}
