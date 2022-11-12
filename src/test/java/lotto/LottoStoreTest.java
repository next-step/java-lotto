package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoStoreTest {
    @Test
    void too_low_purchase_price() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoStore.purchaseAuto(100, 0));
    }

    @Test
    void too_many_manual_count() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoStore.purchaseAuto(2000, 3));
    }

    @Test
    void check_auto_size() {
        assertThat(LottoStore.purchaseAuto(14000, 3)).hasSize(11);
    }
}
