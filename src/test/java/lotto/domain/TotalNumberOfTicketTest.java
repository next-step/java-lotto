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
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(1_000), new LottoTicketPrice());
        assertThat(totalNumberOfTicket.numberOfTicket()).isEqualTo(1);
    }

    @Test
    @DisplayName("구매금액에 따른 구매할 수 있는 로또 티켓 장수 구하기")
    public void count() throws Exception {
        //given
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(1_000), new LottoTicketPrice());

        //when
        int count = totalNumberOfTicket.count();

        //then
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("총 티켓 수 - 수동 티켓 수 = 자동 티켓")
    public void minus() throws Exception {
        //given
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(5_000), new LottoTicketPrice());
        ManualNumberOfTicket manualNumberOfTicket = new ManualNumberOfTicket(3, totalNumberOfTicket);

        //when
        int autoNumberOfTicket = totalNumberOfTicket.minus(manualNumberOfTicket);

        //then
        assertThat(autoNumberOfTicket).isEqualTo(2);
    }
}
