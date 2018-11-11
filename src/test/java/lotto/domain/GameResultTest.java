package lotto.domain;

import lotto.enums.MatchType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void 로또_당첨_전체_금액_계산() {
        Ticket ticket = new Ticket(Arrays.asList(1, 2, 3, 14, 22, 45));
        Ticket ticket2 = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));
        Ticket ticket3 = new Ticket(Arrays.asList(9, 10, 11, 12, 13, 15));

        Ticket winningNumber = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);
        tickets.add(ticket2);
        tickets.add(ticket3);

        GameResult gr = new GameResult(tickets, winningNumber);
        int result = gr.getTotalAmount();
        assertThat(result).isEqualTo(2_000_005_000);
    }

    @Test
    public void 로또_수익률_계산() {
        BigDecimal result = GameResult.calculateBenefitRate(BigDecimal.valueOf(5000), BigDecimal.valueOf(14000));
        assertThat(result).isEqualTo(BigDecimal.valueOf(0.35));
    }
}