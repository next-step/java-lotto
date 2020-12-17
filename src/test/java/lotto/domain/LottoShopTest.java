package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoShopTest {
    @Test
    @DisplayName("천원으로 로또 한장 구매")
    void generateLottos() {
        LottoShop shop = new LottoShop();
        int money = 1000;
        List<Lotto> lottos = shop.getLottos(money);
        assertThat(lottos.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("1000원보다 적을 경우 NoMoneyException")
    void notEnoughMoneyException_test() {
        LottoShop shop = new LottoShop();
        int money = 700;
        assertThatThrownBy(() -> shop.getLottos(money))
                .isInstanceOf(NotEnoughMoneyException.class)
                .hasMessage("돈이 부족합니다.");
    }
}
