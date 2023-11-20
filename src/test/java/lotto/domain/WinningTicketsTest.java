package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningTicketsTest {

        public Ticket newTicket(int[] numbers) {
                return new Ticket(new LottoNumbers(numbers));
        }

        @Test
        void 보너스_번호_포함_로또_결과_수익률_계산() {
                WinningNumbers winningNumbers = new WinningNumbers(new LottoNumber(10), 1, 2, 3, 4, 5, 6);
                Ticket ticket1 = newTicket(new int[]{1, 2, 3, 7, 8, 9});
                Ticket ticket2 = newTicket(new int[]{10, 11, 12, 13, 14, 15});
                Ticket ticket3 = newTicket(new int[]{1, 2, 3, 10, 11, 12});
                Tickets tickets = new Tickets(List.of(ticket1, ticket2, ticket3));
                long purchaseAmount = 3_000;

                WinningTickets winningTickets = tickets.analyzeWinningTickets(winningNumbers);
                assertThat(winningTickets.calculateRateOfBenefit(purchaseAmount)).isEqualTo(18.33);
        }
}
