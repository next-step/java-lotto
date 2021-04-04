package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ManualNumberOfTicketTest {

    @Test
    @DisplayName("수동 로또 티켓 수 생성")
    public void create() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(3_000), new LottoTicketPrice(1_000));
        ManualNumberOfTicket manualNumberOfTicket = new ManualNumberOfTicket(3, totalNumberOfTicket);
        assertThat(manualNumberOfTicket).isEqualTo(new ManualNumberOfTicket(3, totalNumberOfTicket));
    }

    @Test
    @DisplayName("수동 로또 티켓 수가 문자일 경우")
    public void create_error() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(3_000), new LottoTicketPrice(1_000));
        assertThatIllegalArgumentException().isThrownBy(() -> new ManualNumberOfTicket("one", totalNumberOfTicket));
    }

    @Test
    @DisplayName("총 구매 가능한 티켓 개수보다 많을 경우")
    public void validateBound() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(3_000), new LottoTicketPrice(1_000));
        assertThatIllegalArgumentException().isThrownBy(() -> new ManualNumberOfTicket(4, totalNumberOfTicket));
    }
}
