package lotto.domains;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EarningRateTest {

    private Ticket winningTicket = new Ticket("1,2,3,5,8,13");
    private BonusNumber bonusNumber = new BonusNumber("21");
    WinningNumbers winningNumbers = new WinningNumbers(winningTicket, bonusNumber);

    @DisplayName("총 당첨금: 0, 구매 금액: 1000, 수익률: 0.00")
    @Test
    void calculate_1() {
        List<Ticket> ticketList = Collections.singletonList(
            new Ticket("40,41,42,43,44,45") // ZERO
        );
        Tickets tickets = new Tickets(ticketList);
        Scores scores = tickets.scores(winningNumbers);

        EarningRate earningRate = new EarningRate(scores, tickets);

        assertThat(earningRate.toString()).isEqualTo("0.00");
    }

    @DisplayName("총 당첨금: 2000000000, 구매 금액: 1000, 수익률: 2000000.00")
    @Test
    void calculate_2() {
        List<Ticket> ticketList = Collections.singletonList(
            new Ticket("1,2,3,5,8,13") // SIX
        );
        Tickets tickets = new Tickets(ticketList);
        Scores scores = tickets.scores(winningNumbers);

        EarningRate earningRate = new EarningRate(scores, tickets);

        assertThat(earningRate.toString()).isEqualTo("2000000.00");
    }

    @DisplayName("총 당첨금: 5000, 구매 금액: 14000, 수익률: 0.35")
    @Test
    void calculate_3() {
        List<Ticket> ticketList = Arrays.asList(
            new Ticket("1,2,3,43,44,45"), // THREE

            new Ticket("40,41,42,43,44,45"), // ZERO
            new Ticket("40,41,42,43,44,45"), // ZERO
            new Ticket("40,41,42,43,44,45"), // ZERO
            new Ticket("40,41,42,43,44,45"), // ZERO
            new Ticket("40,41,42,43,44,45"), // ZERO

            new Ticket("40,41,42,43,44,45"), // ZERO
            new Ticket("40,41,42,43,44,45"), // ZERO
            new Ticket("40,41,42,43,44,45"), // ZERO
            new Ticket("40,41,42,43,44,45"), // ZERO
            new Ticket("40,41,42,43,44,45"), // ZERO

            new Ticket("40,41,42,43,44,45"), // ZERO
            new Ticket("40,41,42,43,44,45"), // ZERO
            new Ticket("40,41,42,43,44,45") // ZERO
        );
        Tickets tickets = new Tickets(ticketList);
        Scores scores = tickets.scores(winningNumbers);

        EarningRate earningRate = new EarningRate(scores, tickets);

        assertThat(earningRate.toString()).isEqualTo("0.35");
    }
}
