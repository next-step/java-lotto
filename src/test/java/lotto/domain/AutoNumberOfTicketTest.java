package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoNumberOfTicketTest {

    @Test
    @DisplayName("총 티켓 수와 수동 티켓 수를 가지고 자동 로또 티켓 수 생성한다.")
    public void create() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(10_000), new LottoTicketPrice(1_000));
        ManualNumberOfTicket manualNumberOfTicket = new ManualNumberOfTicket(5, totalNumberOfTicket);
        AutoNumberOfTicket autoNumberOfTicket = new AutoNumberOfTicket(manualNumberOfTicket, totalNumberOfTicket);
        assertThat(autoNumberOfTicket.numberOfTicket()).isEqualTo(5);
    }
}
