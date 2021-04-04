package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketOfficeTest {

    @Test
    @DisplayName("총(수동 + 자동) 티켓 판매")
    public void sale() throws Exception {
        //given
        TicketOffice ticketOffice = new TicketOffice(new LottoTicketPrice());
        LottoTickets manualTickets = new LottoTickets(new LottoTicket(LottoNumbers.from(1, 2, 3, 4, 5, 6)));
        LottoTickets autoTickets = new LottoTickets(new LottoTicket(LottoNumbers.from(1, 2, 3, 4, 5, 6)));

        //when
        long numberOfTickets = ticketOffice.sale(manualTickets, autoTickets)
                .lottoTickets()
                .stream()
                .count();

        //then
        assertThat(numberOfTickets).isEqualTo(2);
    }
}
