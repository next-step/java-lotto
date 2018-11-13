package lotto.model;

import lotto.view.InputView;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {
    @Test
    public void 티켓_번호_3개일치() {
        Ticket ticket = new Ticket(InputView.toLottoNums(Arrays.asList(8, 21, 23, 41, 42, 43)), false);
        int matchNums = ticket.countMatch(InputView.toLottoNums(Arrays.asList(1, 2, 3, 8, 21, 43)));
        assertThat(matchNums).isEqualTo(3);
    }

    @Test
    public void 티켓_번호_6개일치() {
        Ticket ticket = new Ticket(InputView.toLottoNums(Arrays.asList(8, 21, 23, 41, 42, 43)), false);
        int matchNums = ticket.countMatch(InputView.toLottoNums(Arrays.asList(8, 21, 23, 41, 42, 43)));
        assertThat(matchNums).isEqualTo(6);
    }
}
