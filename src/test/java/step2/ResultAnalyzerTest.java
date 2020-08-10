package step2;

import org.junit.jupiter.api.Test;
import step2.domain.ResultAnalyzer;
import step2.domain.Ticket;
import step2.domain.TicketSellingMachine;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultAnalyzerTest {

    @Test
    void getMatchTicketCount() {
        Ticket ticket = TicketSellingMachine.ticketing();
        int[] winningNumber = ticket.getNumbers();

        assertThat(
                ResultAnalyzer.getMatchTicketCount(winningNumber, Arrays.asList(ticket), winningNumber.length)
        ).isEqualTo(1);

        assertThat(
                ResultAnalyzer.getMatchTicketCount(winningNumber, Arrays.asList(ticket), winningNumber.length - 1)
        ).isEqualTo(0);
    }

    @Test
    void getRateReturn() {
        Ticket ticket = TicketSellingMachine.ticketing();
        int[] winningNumber = ticket.getNumbers();

        assertThat(
                ResultAnalyzer.getRateReturn(winningNumber, Arrays.asList(ticket), ticket.prizeMoney(winningNumber))
        ).isEqualTo(1.0);
    }
}