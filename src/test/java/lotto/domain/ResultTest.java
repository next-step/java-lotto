package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    @Test
    void test_당첨금계산() {
        Numbers winningNumbers = new Numbers("1, 2, 3, 4, 5, 6");
        Tickets tickets = new Tickets(List.of(new Ticket(new Numbers("1, 2, 3, 4, 5, 6")), new Ticket(new Numbers("1, 2, 3, 4, 5, 45"))));

        Result result = new Result(tickets, winningNumbers);
        assertThat(result.calcWinningAmount()).isEqualTo(2000000000L + 150000000L);
    }

    @Test
    void test_수익률계산() {
        Numbers winningNumbers = new Numbers("1, 2, 3, 4, 5, 6");
        Tickets tickets = new Tickets(List.of(new Ticket(new Numbers("1, 2, 3, 4, 5, 6")), new Ticket(new Numbers("1, 2, 3, 4, 5, 45"))));

        Result result = new Result(tickets, winningNumbers);
        double rateOfReturn = (double) (2000000000L + 150000000L) / 2000L;
        assertThat(result.calcRateOfReturn()).isEqualTo(rateOfReturn);
    }
}