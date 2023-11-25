package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseMoneyTest {

    @Test
    @DisplayName("구입금액은 1000원 이상이어야한다.")
    void test1() {
        int purchaseMoney = 999;
        assertThatThrownBy(() -> new PurchaseMoney(purchaseMoney))
                .hasMessageContaining("1000원 이상");
    }

    @Test
    @DisplayName("수동 구매 금액은 총 구입금액보다 클 수 없다.")
    void test2() {
        int purchaseMoney = 5000;
        ManualCount manualCount = new ManualCount(6);
        assertThatThrownBy(() -> new PurchaseMoney(purchaseMoney, manualCount))
                .hasMessageContaining("수동 구매 금액이 총 구입금액보다 큽니다.");
    }
}