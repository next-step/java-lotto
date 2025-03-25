package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitCalculatorTest {
    @Test
    void calculate() {
        List<LottoTicket> tickets = new ArrayList<>();
        LottoTicket ticket6 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket3 = new LottoTicket(new int[]{1, 2, 3, 14, 15, 16});
        tickets.add(ticket6);
        tickets.add(ticket3);
        LottoTicket winner = new LottoTicket(new int[]{4, 5, 6, 7, 8, 9});

        List<LottoResult> results = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            results.add(ticket.matchWinner(winner));
        }

        assertThat(ProfitCalculator.calculate(LottoChecker.getSummary(results))).isEqualTo(2.5f);
    }
}
