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

    @Test
    @DisplayName("구입 금액이 1000원보다 작을 때 IllegalArgumentException을 던진다.")
    void 구입_금액_1000미만() {
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchaseAmount(900));
    }

    @Test
    @DisplayName("구입 금액이 1000원으로 나누어떨어지지 않을 때 IllegalArgumentException을 던진다.")
    void 구입_금액이_1000으로_안나누어떨어짐() {
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchaseAmount(1400));
    }
}
