package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TicketsTest {

    @Test
    @DisplayName("구매 가능한 수동 로또 티켓 개수 생성")
    void create() {
        PaidAmount paidAmount = new PaidAmount(4000);
        Tickets tickets = new Tickets(3, paidAmount);
        assertThat(tickets).isEqualTo(new Tickets(3, paidAmount));
    }

    @Test
    @DisplayName("구매 가능한 로또 티켓 개수가 구입 금액보다 큰 경우")
    void notPurchasable() {
        PaidAmount paidAmount = new PaidAmount(4000);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Tickets(5, paidAmount));
    }

    @Test
    @DisplayName("구매 가능한 자동 로또 티켓 개수 반환")
    void getAutoLottoTicketNo() {
        PaidAmount paidAmount = new PaidAmount(4000);
        Tickets tickets = new Tickets(3, paidAmount);
        assertThat(tickets.getAutoCount()).isEqualTo(1);
    }
}
