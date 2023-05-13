package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    LottoGame lottoGame = new LottoGame();
    /*List<Integer> ticket = Arrays.asList(1, 3, 5, 14, 22, 45);
    List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 6);*/

    @Test
    void 로또_n장() {

        List<Ticket> tickets = lottoGame.makeTickets(3000);
        for (Ticket ticket : tickets) {
            System.out.println("ticket.getTicket() = " + ticket.getTicket() + " / " + ticket);
        }
        assertThat(tickets).hasSize(3);

    }
}
