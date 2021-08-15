package lotto.ticketingway;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine.OrderInput;
import lotto.domain.TicketCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoWayTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "100,100",})
    @DisplayName("로또 티켓 자동생성방식 사용시, 원하는 티켓수를 입력하는것으로  그수만큼의 로또 티켓을 얻을수 있다.")
    void issue_auto_way_lotto_tickets(int ticketCount, int expectedSize) {
        AutoWay autoWay = new AutoWay();
        List<LottoTicket> tickets = autoWay
            .issueLottoTickets(new OrderInput(new TicketCount(ticketCount)));

        assertThat(tickets.size()).isEqualTo(expectedSize);
    }

}