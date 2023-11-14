package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.RandomNumbers;
import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;

public class TicketTest {

        @Test
        void 한_장의_로또_티켓_내_포함된_당첨_번호_갯수() {
                RandomNumbers numbers = new RandomNumbers(List.of(1, 2, 3, 7, 8, 9));
                List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
                Ticket ticket = new Ticket(numbers);

                ticket.matchInOneTicket(winningNumbers);
                
                assertThat(ticket.matchCount()).isEqualTo(3);
        }
}
