package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @Test
    void getInvalidPurchaseAmount() {
        assertThatThrownBy(() -> PurchaseAmount.of(1000, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getValidPurchaseAmount() {
        assertThatNoException()
                .isThrownBy(() -> PurchaseAmount.of(1000, 1));
    }
}