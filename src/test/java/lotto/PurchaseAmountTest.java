package lotto;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseAmountTest {

    @Test
    @DisplayName("구매 금액 객체 생성")
    public void create() throws Exception {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        assertThat(purchaseAmount).isEqualTo(new PurchaseAmount(1000));
        purchaseAmount = new PurchaseAmount("1000");
        assertThat(purchaseAmount).isEqualTo(new PurchaseAmount("1000"));
    }

    @Test
    @DisplayName("1000원 미만일 시 예외")
    public void checkMinimum() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchaseAmount(999));
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchaseAmount("999"));
    }
}
