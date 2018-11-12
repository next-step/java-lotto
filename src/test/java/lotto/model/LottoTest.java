package lotto.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또_0장구매() {
        Lotto lotto = new Lotto(0L);
        List<Ticket> tickets = lotto.getTickets();
        assertThat(tickets.size()).isEqualTo(0);
    }

    @Test
    public void 로또_4장구매() {
        Lotto lotto = new Lotto(4000L);
        List<Ticket> tickets = lotto.getTickets();
        assertThat(tickets.size()).isEqualTo(4);
    }
}
