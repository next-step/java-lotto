package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BuyingAmountTest {

    @Test
    void 로또번호를_1000원_단위로_살_수_있다() {
        assertDoesNotThrow(() -> new BuyingAmount(14000));
    }

    @Test
    void 로또번호를_1000원_단위로_살_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> new BuyingAmount(14500));
    }

}
