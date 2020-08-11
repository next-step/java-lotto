package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoRanking;
import step2.domain.ResultAnalyzer;
import step2.domain.Ticket;
import step2.domain.TicketSellingMachine;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultAnalyzerTest {

    @Test
    void getMatchTicketCount() {
        int[] winningNumber = new int[]{1, 2, 3, 4, 5, 6};
        Ticket ticket = new Ticket(winningNumber);

        assertThat(
                ResultAnalyzer.getMatchTicketCount(winningNumber, 0, winningNumber.length, 0, Arrays.asList(ticket))
        ).isEqualTo(1);

        assertThat(
                ResultAnalyzer.getMatchTicketCount(winningNumber, 0, winningNumber.length - 1, 0, Arrays.asList(ticket))
        ).isEqualTo(0);
    }

    @Test
    void getPrizeMoney() {
        int[] winningNumber = new int[]{1, 2, 3, 4, 5, 6};
        Ticket ticket = new Ticket(winningNumber);

        assertThat(ResultAnalyzer.getPrizeMoney(winningNumber, 0, ticket)).isEqualTo(LottoRanking.FIRST.getPrizeMoney());
    }

    @Test
    void getPrizeMoneyForSecond() {
        int[] winningNumber = new int[]{1, 2, 3, 4, 5, 6};
        Ticket ticket = new Ticket(new int[]{1, 2, 3, 4, 5, 7});

        assertThat(ResultAnalyzer.getPrizeMoney(winningNumber, 7, ticket)).isEqualTo(LottoRanking.SECOND.getPrizeMoney());
    }

    @Test
    void getPrizeMoneyForThird() {
        int[] winningNumber = new int[]{1, 2, 3, 4, 5, 6};
        Ticket ticket = new Ticket(new int[]{1, 2, 3, 4, 5, 7});

        assertThat(ResultAnalyzer.getPrizeMoney(winningNumber, 0, ticket)).isEqualTo(LottoRanking.THIRD.getPrizeMoney());
    }

    @Test
    void getRateReturn() {
        int[] winningNumber = new int[]{1, 2, 3, 4, 5, 6};
        Ticket ticket = new Ticket(winningNumber);

        assertThat(
                ResultAnalyzer.getRateReturn(winningNumber, 0, Arrays.asList(ticket), LottoRanking.FIRST.getPrizeMoney())
        ).isEqualTo(1.0);
    }
}