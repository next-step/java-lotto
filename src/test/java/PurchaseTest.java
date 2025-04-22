import Lotto.domain.Purchase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PurchaseTest {

    @Test
    void 정상_금액이면_로또_개수_계산됨() {
        Purchase purchase = new Purchase(14000);
        assertThat(purchase.getQuantity()).isEqualTo(14);
    }

    @Test
    void 금액이_음수면_예외_발생() {
        assertThatThrownBy(() -> new Purchase(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000원 단위의 양수여야 합니다.");
    }

    @Test
    void 금액이_0원이면_예외_발생() {
        assertThatThrownBy(() -> new Purchase(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000원 단위의 양수여야 합니다.");
    }

    @Test
    void 금액이_1000원_단위가_아니면_예외_발생() {
        assertThatThrownBy(() -> new Purchase(14501))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000원 단위의 양수여야 합니다.");
    }
}
