package humbledude.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void newLotto() {
        LottoTicket ticket = new LottoTicket();

        assertThat(ticket.getNumbers())
                .isInstanceOf(Set.class)
                .hasSize(6)
                .allSatisfy(n -> assertThat(n).isBetween(1, 45));
    }
}
