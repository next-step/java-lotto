package step2;

import org.junit.jupiter.api.Test;
import step2.model.PurchaseAmount;

import static org.assertj.core.api.Assertions.*;

public class PurchaseAmountTest {
    @Test
    public void 구매금액_null_빈문자() {
        assertThatThrownBy(() -> new PurchaseAmount(""))
                        .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new PurchaseAmount(null))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매금액_숫자가아님() {
        assertThatThrownBy(() -> new PurchaseAmount("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매금액_1000미만() {
        assertThatThrownBy(() -> new PurchaseAmount("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
