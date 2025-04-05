package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PurchaseCountTest {
    @Test
    void createTest() {
        PurchaseCount purchaseCount = new PurchaseCount(1);
        assertThat(purchaseCount).isEqualTo(new PurchaseCount(1));
    }

    @Test
    void invalidTest() {
        assertThatThrownBy(() -> new PurchaseCount(-1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid purchase amount");
    }

    @Test
    void decreaseTest() {
        assertThat(new PurchaseCount(2).decrease()).isEqualTo(new PurchaseCount(1));
    }

    @Test
    void isPositiveTest() {
        assertThat(new PurchaseCount(1).isPositive()).isTrue();
    }
}