package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.MISS;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TicketsTest {

        public Ticket newTicket(int[] numbers) {
                return new Ticket(new LottoNumbers(numbers));
        }

        @Test
        void 보너스_번호_포함_당첨_티켓_결과() {
                WinningNumbers winningNumbers = new WinningNumbers(new LottoNumber(10), 1, 2, 3, 4, 5, 6);
                Ticket ticket1 = newTicket(new int[]{1, 2, 3, 7, 8, 9});
                Ticket ticket2 = newTicket(new int[]{10, 11, 12, 13, 14, 15});
                Ticket ticket3 = newTicket(new int[]{1, 2, 3, 10, 11, 12});
                Tickets tickets = new Tickets(List.of(ticket1, ticket2, ticket3));

                Map<Rank, Integer> actual = tickets.analyzeWinningTickets(winningNumbers).values();
                Map<Rank, Integer> expected = Map.of(
                    FIRST, 0,
                    SECOND, 0,
                    THIRD, 0,
                    FOURTH, 1,
                    FIFTH, 1,
                    MISS, 1
                );
                assertThat(actual).isEqualTo(expected);
        }
}
