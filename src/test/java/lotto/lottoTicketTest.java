package lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class lottoTicketTest {
    @Test
    @DisplayName("금액에 맞춰 티켓이 생성되는지")
    public void generateNumber() {
        LottoTickets lottoTickets = new LottoTickets("15500");
        assertThat(lottoTickets.getNumberOfTickets()).isEqualTo(15);
        assertThat(lottoTickets.checkValidTickets()).isTrue();
    }
}
