package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.Ticket;
import lotto.domain.WinningTicket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningTicketTest {

    @Test
    void create() {
        Ticket ticket = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningTicket winningTicket = new WinningTicket(ticket, bonusNumber);

        assertThat(winningTicket.getTicket()).isEqualTo(ticket);
        assertThat(winningTicket.getBonusNumber()).isEqualTo(LottoNumber.of(bonusNumber));
    }

    @Test
    void create_보너스번호가_당첨번호와_겹치면_실패() {
        Ticket ticket = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningTicket(ticket, bonusNumber));
    }

    @Test
    void create_보너스번호가_없을시_실패() {
        Ticket ticket = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatIllegalArgumentException().isThrownBy(() -> new WinningTicket(ticket, null));
    }
}
