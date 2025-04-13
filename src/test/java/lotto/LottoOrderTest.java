package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Count;
import lotto.domain.LottoOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoOrderTest {

    @Test
    @DisplayName("수동 구매 티켓 수는 전체 티켓 수를 초과할 수 없다.")
    void shouldThrowExceptionWhenManualTicketCountExceedsTotalTicketCount() {
        assertThatThrownBy(() -> new LottoOrder(5000, 6))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동 구매 티켓 수는 전체 티켓 수를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동 구매 티켓 수는 전체 티켓 수 - 수동 구매 티켓 수이다.")
    void shouldCalculateAutoTicketCount() {
        LottoOrder order = new LottoOrder(5000, 3);
        assertThat(order.getAutoTicketCount()).isEqualTo(new Count(2));
    }
}
