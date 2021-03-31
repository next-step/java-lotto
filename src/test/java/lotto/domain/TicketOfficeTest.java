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
        NumberOfTicket numberOfTicket = ticketOffice.numberOfTicket(purchaseAmount);
        LottoTickets lottoTickets = ticketOffice.sale(numberOfTicket);

        //then
        assertThat(lottoTickets.lottoTickets()).hasSize(10);
    }


    @Test
    @DisplayName("구매 금액으로 구입할 수 있는 티켓 장수 구하기")
    public void numberOfTicket() throws Exception {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount(1_000);
        TicketOffice ticketOffice = new TicketOffice(new LottoTicketPrice());

        //when
        NumberOfTicket numberOfTicket = ticketOffice.numberOfTicket(purchaseAmount);

        //then
        assertThat(numberOfTicket.count()).isEqualTo(1);
    }
}
