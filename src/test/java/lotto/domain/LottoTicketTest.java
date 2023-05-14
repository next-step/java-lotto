package lotto.domain;


import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {
    @Test
    @DisplayName("금액에 맞춰 티켓이 생성되는지")
    public void generateNumber() {
        LottoTickets lottoTickets = LottoGenerator.generateTickets(15500);
        assertThat(lottoTickets.getNumberOfTickets()).isEqualTo(15);
        assertThat(lottoTickets.checkValidTickets()).isTrue();
    }
}
