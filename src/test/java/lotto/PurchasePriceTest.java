package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasePriceTest {

    @Test
    @DisplayName("구매 금액은 0원 이상이어야 한다")
    void shouldThrowExceptionWhenPurchaseAmountIsLessThanZero() {
        assertThatThrownBy(() -> new PurchasePrice("-1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구입 금액은 0원보다 커야 합니다.");
    }

    @Test
    @DisplayName("구매 금액은 숫자여야 한다")
    void shouldThrowExceptionWhenNotNumber() {
        assertThatThrownBy(() -> new PurchasePrice("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구입 금액은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("구매 금액으로 구매 가능한 티켓 수를 계산한다")
    void shouldCalculateTicketCount() {
        PurchasePrice price = new PurchasePrice("5000");
        assertThat(price.calculateTicketCount(1000)).isEqualTo(5);
    }

}
