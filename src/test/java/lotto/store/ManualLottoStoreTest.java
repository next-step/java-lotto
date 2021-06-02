package lotto.store;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.dto.ManualGameDto;

class ManualLottoStoreTest {

    @Test
    @DisplayName(value = "구매 불가능한 금액을 입력하는 경우 IllegalArgumentException 을 일으킨다")
    void isPurchasable() {
        assertThrows(IllegalArgumentException.class,
            () -> new ManualLottoStore(new ManualGameDto(new Budget(500), new ManualCount(0)),  1_000));
    }

}