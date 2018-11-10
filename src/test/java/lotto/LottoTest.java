package lotto;

import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또_0장구매() {
        Lotto lotto = new Lotto(0);
        List<Ticket> tickets = lotto.getTickets();
        assertThat(tickets.size()).isEqualTo(0);
    }

    @Test
    public void 로또_4장구매() {
        Lotto lotto = new Lotto(4);
        List<Ticket> tickets = lotto.getTickets();
        assertThat(tickets.size()).isEqualTo(4);
    }
}
