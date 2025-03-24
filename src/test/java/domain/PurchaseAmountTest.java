package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchaseAmountTest {
    @Test
    @DisplayName("구입 금액으로 살 수 있는 로또 수를 계산한다")
    void 로또_수() {
        PurchaseAmount amount = new PurchaseAmount(14000);
        assertThat(amount.countOfLotto()).isEqualTo(14);
    }
}
