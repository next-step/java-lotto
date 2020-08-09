package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoRanking;
import step2.domain.ResultAnalyzer;
import step2.domain.Ticket;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @Test
    void constructor() {
        Ticket ticket = new Ticket();

        assertThat(ticket.getNumbers().length).isEqualTo(6);
    }

    @Test
    void getHitCount() {
        Ticket ticket = new Ticket();
        int[] numbers = ticket.getNumbers();

        assertThat(ticket.getHitCount(numbers)).isEqualTo(numbers.length);
    }

    @Test
    void getPrizeMoney() {
        Ticket matchTicket = new Ticket();
        int[] winningNumber = matchTicket.getNumbers();

        assertThat(matchTicket.getPrizeMoney(winningNumber)).isEqualTo(LottoRanking.FIRST.getPrizeMoney());
    }
}