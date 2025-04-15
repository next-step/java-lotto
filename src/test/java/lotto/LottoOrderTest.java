package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoOrder;
import lotto.domain.LottoTicket;
import lotto.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoOrderTest {

    @Test
    @DisplayName("수동 구매 티켓 수는 전체 티켓 수를 초과할 수 없다.")
    void shouldThrowExceptionWhenManualTicketCountExceedsTotalTicketCount() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));

        assertThatThrownBy(() -> new LottoOrder(new Price(1000), lottoTickets))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동 구매 티켓 수는 전체 티켓 수를 초과할 수 없습니다.");
    }

}
