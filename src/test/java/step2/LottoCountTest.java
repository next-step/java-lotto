package step2;

import org.junit.jupiter.api.Test;
import step2.model.LottoCount;
import step2.model.PurchaseAmount;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {
    @Test
    public void 구매갯수_null_빈문자() {
        assertThatThrownBy(() -> new LottoCount(new PurchaseAmount("14000"), ""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoCount(new PurchaseAmount("14000"), null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매갯수_숫자아님() {
        assertThatThrownBy(() -> new LottoCount(new PurchaseAmount("14000"), "test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매갯수_범위_벗어남() {
        assertThatThrownBy(() -> new LottoCount(new PurchaseAmount("14000"), "-1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoCount(new PurchaseAmount("14000"), "15"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
