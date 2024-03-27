package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketBall;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketBallTest {

    private LottoTicketBall ticketBall = new LottoTicketBall();

    @ParameterizedTest
    @ValueSource(ints = 6)
    public void 로또_티켓은_6개의_숫자로_구성(int size) {
        LottoTicket ticket = ticketBall.generateTicket();
        assertThat(ticket.getNumbers().size()).isEqualTo(size);
    }

}
