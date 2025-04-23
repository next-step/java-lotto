import lotto.domain.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PurchaseTest {

    @DisplayName("정상 금액이면 로또 개수가 계산된다")
    @Test
    void should_calculate_lotto_quantity_with_valid_amount() {
        Purchase purchase = new Purchase(14000);
        assertThat(purchase.getQuantity()).isEqualTo(14);
    }

    @DisplayName("금액이 음수이면 예외가 발생한다")
    @Test
    void should_throw_exception_when_amount_is_negative() {
        assertThatThrownBy(() -> new Purchase(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000원 단위의 양수여야 합니다.");
    }

    @DisplayName("금액이 0원이면 예외가 발생한다")
    @Test
    void should_throw_exception_when_amount_is_zero() {
        assertThatThrownBy(() -> new Purchase(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000원 단위의 양수여야 합니다.");
    }

    @DisplayName("금액이 1000원 단위가 아니면 예외가 발생한다")
    @Test
    void should_throw_exception_when_amount_is_not_multiple_of_1000() {
        assertThatThrownBy(() -> new Purchase(14501))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000원 단위의 양수여야 합니다.");
    }
}

