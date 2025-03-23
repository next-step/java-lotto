package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {
    @Test
    void check_lotto() {
        LottoTicket ticket6 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket3 = new LottoTicket(new int[]{1, 2, 3, 14, 15, 16});

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(ticket6);
        tickets.add(ticket3);
        List<LottoResult> results = LottoChecker.checkTickets(tickets, ticket6);

        LottoResult expected6 = new LottoResult(ticket6, new MatchCount(6));
        LottoResult expected3 = new LottoResult(ticket3, new MatchCount(3));

        assertThat(results).contains(expected6, expected3);
    }
}
