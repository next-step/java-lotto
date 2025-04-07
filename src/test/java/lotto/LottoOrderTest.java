package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoOrderTest {

    @Test
    @DisplayName("구매 금액은 1000원 이상이어야 한다")
    void shouldThrowExceptionWhenPurchaseAmountIsLessThanZero() {
        assertThatThrownBy(() -> new LottoOrder("500"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구입 금액은 1000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("구매 금액은 숫자여야 한다")
    void shouldThrowExceptionWhenNotNumber() {
        assertThatThrownBy(() -> new LottoOrder("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구입 금액은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("구매 금액으로 구매 가능한 티켓 수를 계산한다")
    void shouldCalculateTicketCount() {
        LottoOrder price = new LottoOrder("5000");
        assertThat(price.getTicketCount()).isEqualTo(5);
    }

}
