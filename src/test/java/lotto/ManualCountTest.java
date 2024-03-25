package lotto;

import lotto.view.PurchaseLimit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManualCountTest {

    @Test
    void decrease_purchase_count_as_mush_manual_count() {
        ManualCount manualCount = new ManualCount(3, new PurchaseLimit(10));

        assertThat(manualCount.estimateAuto(10)).isEqualTo(new AutoCount(7));
    }
}