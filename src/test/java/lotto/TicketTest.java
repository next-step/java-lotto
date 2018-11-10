package lotto;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {
    @Test
    public void 티켓_번호_3개일치() {
        Ticket ticket = new Ticket(Arrays.asList(8, 21, 23, 41, 42, 43));
        int matchNums = ticket.countMatch(Arrays.asList(1, 2, 3, 8, 21, 43));
        assertThat(matchNums).isEqualTo(3);
    }

    @Test
    public void 티켓_번호_6개일치() {
        Ticket ticket = new Ticket(Arrays.asList(8, 21, 23, 41, 42, 43));
        int matchNums = ticket.countMatch(Arrays.asList(8, 21, 23, 41, 42, 43));
        assertThat(matchNums).isEqualTo(6);
    }
}
