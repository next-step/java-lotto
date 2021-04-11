package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalNumberOfTicketTest {

    @Test
    @DisplayName("구매 금액과 로또 티켓 한 장 가격을 통해 구매할 수 있는 티켓의 수 객체를 생성한다.")
    public void create() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(10_000), new LottoTicketPrice(5_000));
        assertThat(totalNumberOfTicket).isEqualTo(new TotalNumberOfTicket(new PurchaseAmount(4_000), new LottoTicketPrice(2_000)));
    }

    @Test
    @DisplayName("구매할 수 있는 티켓 장수를 반환한다.")
    public void numberOfTicket() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(1_000), new LottoTicketPrice());
        assertThat(totalNumberOfTicket.numberOfTicket()).isEqualTo(1);
    }

    @Test
    @DisplayName("구매 금액을 로또 티켓 한 장 가격으로 나누어 총 장수를 반환한다.")
    public void count() throws Exception {
        //given
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(1_000), new LottoTicketPrice());

        //when
        int count = totalNumberOfTicket.count();

        //then
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("총 티켓 수에서 수동 티켓 수를 제외하면 자동 티켓의 수가 나온다.")
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
