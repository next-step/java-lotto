package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoRanking;
import step2.domain.Ticket;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @Test
    void matchCount() {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        Ticket ticket = new Ticket(numbers);

        assertThat(ticket.matchCount(numbers)).isEqualTo(numbers.length);
    }

    @Test
    void getPrizeMoney() {
        int[] winningNumber = new int[]{1, 2, 3, 4, 5, 6};
        Ticket matchTicket = new Ticket(winningNumber);

        assertThat(matchTicket.prizeMoney(winningNumber)).isEqualTo(LottoRanking.FIRST.getPrizeMoney());
    }
}