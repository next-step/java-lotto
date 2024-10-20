package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasePriceTest {
    @Test
    void 구입금액_객체생성() {
        PurchasePrice purchasePrice = new PurchasePrice(14000);
        assertThat(purchasePrice).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, 0, 1400})
    void 구입금액_검증(int value) {
        assertThatThrownBy(() -> new PurchasePrice(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입개수_구하기() {
        PurchasePrice purchasePrice = new PurchasePrice(14000);
        assertThat(purchasePrice.calculateAutoCount()).isEqualTo(14);
    }
}