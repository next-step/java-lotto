package kr.heesu.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {
    private PurchaseAmount amount;

    @Test
    void amount_test() {
        amount = PurchaseAmount.of(1020);

        assertThat(amount.getSize()).isEqualTo(1);
        assertThatThrownBy(() -> PurchaseAmount.of(700)).isInstanceOf(IllegalArgumentException.class);
    }
}