package lotto;
import lotto.domain.LottoTicket;
import lotto.rule.LottoSetUp;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    LottoTicket ticket;

    @Before
    public void setUp(){
        ticket = new LottoTicket();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void 로또티켓_예외처리(){
        LottoSetUp.setUpLottoRule(6,1,1000);
        LottoTicket ticket = new LottoTicket();
    }
}