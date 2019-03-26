package lotto;
import lotto.domain.LottoTicket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void 유저로또티켓_확인(){
        List<LottoTicket> tickets = new ArrayList<LottoTicket>();
        tickets.add(new LottoTicket());
        tickets.add(new LottoTicket());
        tickets.add(new LottoTicket());
        tickets.add(new LottoTicket());
        tickets.add(new LottoTicket());
        assertThat(tickets.get(0).getTicket()).hasSize(6);
    }
}