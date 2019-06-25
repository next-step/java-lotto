package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    static private List<Integer> INPUT_SAMPLE_NUMBERS = Arrays.asList(1,2,3,4,5,6);
    private LottoTicket ticket;
    private LottoTickets tickets;

    @BeforeEach
    void setUp() {
        ticket = new LottoTicket(INPUT_SAMPLE_NUMBERS);
        tickets = new LottoTickets(Arrays.asList(ticket, ticket));
    }

    @Test
    void 티켓을_가진다() {
        assertThat(tickets.size()).isEqualTo(2);
    }

    @Test
    void 당첨티켓과_비교하여_당첨수를_반환한다() {
        LottoResult result = tickets.checkWin(ticket);
        assertThat(result.numOf(6)).isEqualTo(2);
    }
}
