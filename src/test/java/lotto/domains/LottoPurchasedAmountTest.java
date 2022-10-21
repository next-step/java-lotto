package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoPurchasedAmountTest {
    @Test
    void testNegativeAmount() {
        assertThatThrownBy(() -> new LottoPurchasedAmount("-1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testExceededAmount() {
        assertThatThrownBy(() -> new LottoPurchasedAmount("1000000")).isInstanceOf(IllegalArgumentException.class);
    }
}
