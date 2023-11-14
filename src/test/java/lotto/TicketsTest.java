package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.RandomNumbers;
import lotto.domain.Ticket;
import lotto.domain.Tickets;
import org.junit.jupiter.api.Test;

public class TicketsTest {

        @Test
        void 로또_결과_수익률_계산() {
                long purchaseAmount = 3_000;
                RandomNumbers numbers1 = new RandomNumbers(List.of(1, 2, 3, 7, 8, 9)); // 5000원
                Ticket ticket1 = new Ticket(numbers1);
                RandomNumbers numbers2 = new RandomNumbers(List.of(10, 11, 12, 13, 14, 15));
                Ticket ticket2 = new Ticket(numbers2);
                RandomNumbers numbers3 = new RandomNumbers(List.of(1, 2, 3, 4, 10, 11)); // 50000원
                Ticket ticket3 = new Ticket(numbers3);
                List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
                Tickets tickets = new Tickets(List.of(ticket1, ticket2, ticket3));
                
                tickets.analyzeLottoResults(winningNumbers, purchaseAmount);

                assertThat(tickets.rateOfBenefit()).isEqualTo(18.33);
        }
}
