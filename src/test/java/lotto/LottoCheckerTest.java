package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {
    @Test
    void summary_results() {
        List<LottoTicket> tickets = new ArrayList<>();
        LottoTicket ticket6 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket3 = new LottoTicket(new int[]{1, 2, 3, 14, 15, 16});
        tickets.add(ticket6);
        tickets.add(ticket3);

        Map<PrizeRank, Integer> expected = new HashMap<>();
        expected.put(PrizeRank.FIRST, 1);
        expected.put(PrizeRank.FOURTH, 1);

        assertThat(LottoChecker.getSummary(tickets, ticket6)).containsAllEntriesOf(expected);
    }
}
