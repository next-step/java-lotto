package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoPurchaseAmountTest {

    @Test
    void invalidArgumentTest() {
        assertThatThrownBy(() -> new LottoPurchaseAmount(500)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void amountTest() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(15_000);
        assertThat(lottoPurchaseAmount.amount()).isEqualTo(15);
    }
}
