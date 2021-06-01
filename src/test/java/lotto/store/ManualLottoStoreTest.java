package lotto.store;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualLottoStoreTest {

    @Test
    @DisplayName(value = "전체 구매가능 개수 보다 수동으로 구매하는 개수가 더 많으면 IllegalAgrumentException을 일으킨다")
    void isManualPossible() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new ManualLottoStore(new Budget(10_000), 1000, 11)
        );
    }

    @Test
    @DisplayName(value = "구매 불가능한 금액을 입력하는 경우 IllegalArgumentException 을 일으킨다")
    void isPurchasable() {
        assertThrows(IllegalArgumentException.class,
            () -> new ManualLottoStore(new Budget(500), 1_000, 0));
    }

}