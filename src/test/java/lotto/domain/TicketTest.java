package lotto.domain;

import lotto.enums.MatchType;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {

    @Test
    public void 로또티켓과_당첨번호가_몇개_일치하는지_테스트() {
        Ticket ticket = new Ticket(Arrays.asList(1, 3, 5, 14, 22, 45));
        WinningLotto winningNumber = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        MatchType type = ticket.compareWinningLotto(winningNumber);
        int result = type.getMatch();
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 로또티켓에_보너스볼이_당첨되었는지_테스트() {
        Ticket ticket = new Ticket(Arrays.asList(1, 3, 4, 5, 2, 7));
        WinningLotto winningNumber = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        MatchType type = ticket.compareWinningLotto(winningNumber);
        int result = type.getMatch();
        assertThat(result).isEqualTo(MatchType.BONUS.getMatch());
    }
}