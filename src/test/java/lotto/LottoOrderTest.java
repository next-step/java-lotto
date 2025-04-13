package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Count;
import lotto.domain.LottoOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoOrderTest {

    @Test
    @DisplayName("구매 금액은 1000원 이상이어야 한다")
    void shouldThrowExceptionWhenPurchaseAmountIsLessThanZero() {
        assertThatThrownBy(() -> new LottoOrder(500, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("하나 이상의 티켓을 구매해야 합니다.");
    }

    @Test
    @DisplayName("구매 금액으로 구매 가능한 티켓 수를 계산한다")
    void shouldCalculateTicketCount() {
        LottoOrder price = new LottoOrder(5000, 0);
        assertThat(price.getTotalCount()).isEqualTo(new Count(5));
    }

    @Test
    @DisplayName("구매 티켓 수는 음수일 수 없다.")
    void shouldThrowExceptionWhenManualTicketCountIsNegative() {
        assertThatThrownBy(() -> new LottoOrder(5000, -1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동 구매 티켓 수는 전체 티켓 수를 초과할 수 없다.")
    void shouldThrowExceptionWhenManualTicketCountExceedsTotalTicketCount() {
        assertThatThrownBy(() -> new LottoOrder(5000, 6))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동 구매 티켓 수는 전체 티켓 수를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동 구매 티켓 수는 전체 티켓 수 - 수동 구매 키텟 수이다.")
    void shouldCalculateAutoTicketCount() {
        LottoOrder order = new LottoOrder(5000, 3);
        assertThat(order.getAutoTicketCount()).isEqualTo(new Count(2));
    }
}
