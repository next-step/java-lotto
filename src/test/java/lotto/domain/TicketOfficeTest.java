package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketOfficeTest {

    @Test
    @DisplayName("구매 금액만큼의 티켓 생성")
    public void sale() throws Exception {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount(10_000);
        TicketOffice ticketOffice = new TicketOffice(new LottoTicketPrice());

        //when
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(purchaseAmount, ticketOffice.lottoTicketPrice());
        LottoTickets lottoTickets = ticketOffice.sale(totalNumberOfTicket);

        //then
        assertThat(lottoTickets.lottoTickets()).hasSize(10);
    }
}
