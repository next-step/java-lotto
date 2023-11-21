package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseMoneyTest {

    @Test
    @DisplayName("구입금액은 1000원 이상이어야한다.")
    void test2() {
        int purchaseMoney = 999;
        assertThatThrownBy(() -> new PurchaseMoney(purchaseMoney))
                .hasMessageContaining("1000원 이상");
    }

}