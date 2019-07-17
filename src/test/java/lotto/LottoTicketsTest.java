package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private static final List<Integer> INPUT_SAMPLE_NUMBERS = Arrays.asList(1,2,3,4,5,6);
    private LottoTicket ticket;
    private LottoTickets tickets;

    @BeforeEach
    void setUp() {
        ticket = LottoTicket.of(INPUT_SAMPLE_NUMBERS);
        tickets = new LottoTickets(Arrays.asList(ticket, ticket));
    }

    @Test
    void 티켓을_가진다() {
        assertThat(tickets.size()).isEqualTo(2);
    }
}
