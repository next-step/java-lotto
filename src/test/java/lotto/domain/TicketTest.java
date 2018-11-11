package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {

    @Test
    public void 로또티켓과_당첨번호가_몇개_일치하는지_테스트() {
        Ticket ticket = new Ticket(Arrays.asList(1, 3, 5, 14, 22, 45));
        WinningLotto winningNumber = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        int result = ticket.getCountOfMatches(winningNumber.getNumbers());
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 보너스볼을_가지고_있는지_테스트() {
        Ticket ticket = new Ticket(Arrays.asList(1, 3, 4, 5, 2, 7));
        WinningLotto winningNumber = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        boolean result = ticket.hasBonus(winningNumber.getBonus());
        assertThat(result).isEqualTo(true);
    }

}