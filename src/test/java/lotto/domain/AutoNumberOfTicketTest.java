package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoNumberOfTicketTest {

    @Test
    @DisplayName("자동 로또 티켓 수 생성")
    public void create() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(5_000), new LottoTicketPrice(1_000));
        ManualNumberOfTicket manualNumberOfTicket = new ManualNumberOfTicket(3, totalNumberOfTicket);
        AutoNumberOfTicket autoNumberOfTicket = new AutoNumberOfTicket(manualNumberOfTicket, totalNumberOfTicket);
        assertThat(autoNumberOfTicket).isEqualTo(new AutoNumberOfTicket(manualNumberOfTicket, totalNumberOfTicket));
    }
}
