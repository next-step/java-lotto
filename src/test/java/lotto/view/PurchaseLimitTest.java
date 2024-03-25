package lotto.view;

import lotto.AutoCount;
import lotto.ManualCount;
import lotto.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseLimitTest {

    @Test
    void decrease_budget_as_mush_manual_count() {
        PurchaseLimit purchaseLimit = new PurchaseLimit(new Money(4000), new Money(1000));
        assertThat(purchaseLimit.decrease(new ManualCount(3, purchaseLimit))).isEqualTo(new AutoCount(1));
    }
}