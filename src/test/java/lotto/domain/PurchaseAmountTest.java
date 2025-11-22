package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {

    @Test
    void 구입_금액_생성한다생성한다() {
        PurchaseAmount amount = new PurchaseAmount(5000);

        assertThat(amount.getAmount()).isEqualTo(5000);
    }

    @Test
    void 천원_단위가_아니면_예외발생() {
        assertThatThrownBy(() -> new PurchaseAmount(5500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1000원 단위여야 합니다.");
    }


    @Test
    void 영이면_예외발생() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 0보다 커야 합니다.");
    }

}
