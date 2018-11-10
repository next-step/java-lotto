package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {

    @Test
    public void 로또티켓과_당첨번호가_몇개_일치하는지_테스트() {
        Ticket ticket = new Ticket(Arrays.asList(1, 3, 5, 14, 22, 45));
        Ticket winningNumber = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));

        int result = ticket.getCountOfMatches(winningNumber);
        assertThat(result).isEqualTo(3);
    }

}