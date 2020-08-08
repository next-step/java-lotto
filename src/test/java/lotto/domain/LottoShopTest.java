package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {

    @Test
    @DisplayName("구매금액 0 또는 음수")
    void buy_negativePrice_exceptThrown() {
        assertThatThrownBy(() -> LottoShop.buyAuto(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoShop.buyAuto(-1000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매금액 천원 단위가 아닐 경우")
    void buy_notDivided1000_exceptThrown() {
        assertThatThrownBy(() -> LottoShop.buyAuto(150)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매금액에 따라 정확한 개수 구매")
    void buy() {
        int price = 14000;
        assertThat(LottoShop.buyAuto(price)).hasSize(price / 1000);
    }


}
