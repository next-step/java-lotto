package lotto;
import lotto.domain.LottoTicket;
import org.junit.Before;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    LottoTicket ticket;

    @Before
    public void setUp(){
        ticket = new LottoTicket();
    }

    public void 유저로또티켓_확인(){
        List<Integer> numbers = ticket.getTicket();
        assertThat(numbers).hasSize(6);
    }
}