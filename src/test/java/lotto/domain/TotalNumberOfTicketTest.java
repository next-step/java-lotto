package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalNumberOfTicketTest {

    @Test
    @DisplayName("티켓의 수 객체 생성")
    public void create() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(10_000), new LottoTicketPrice(5_000));
        assertThat(totalNumberOfTicket).isEqualTo(new TotalNumberOfTicket(new PurchaseAmount(4_000), new LottoTicketPrice(2_000)));
    }

    @Test
    @DisplayName("구매 금액으로 구입할 수 있는 티켓 장수 구하기")
    public void numberOfTicket() throws Exception {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount(1_000);
        TicketOffice ticketOffice = new TicketOffice(new LottoTicketPrice());

        //when
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(purchaseAmount, ticketOffice.lottoTicketPrice());

        //then
        assertThat(totalNumberOfTicket.numberOfTicket()).isEqualTo(1);
    }

    @Test
    @DisplayName("구매금액에 따른 구매할 수 있는 로또 티켓 장수 구하기")
    public void count() throws Exception {
        //given
        LottoTicketPrice lottoTicketPrice = new LottoTicketPrice();
        PurchaseAmount purchaseAmount = new PurchaseAmount(1_000);
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(purchaseAmount, lottoTicketPrice);

        //when
        int count = totalNumberOfTicket.count();

        //then
        assertThat(count).isEqualTo(1);
    }
}
