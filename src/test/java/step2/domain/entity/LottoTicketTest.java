package step2.domain.entity;

import org.junit.jupiter.api.Test;
import step2.domain.vo.LottoPrize;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    void 로또에_당첨되면_티켓의_상태가_변경된다() {
        final var lotto = new Lotto(1, 2, 3, 4, 5, 6);
        final var ticket = new LottoTicket(lotto);
        final var actual = LottoPrize.THIRD;

        ticket.changeLottoPrizeStatus(actual);

        assertThat(actual).isEqualTo(ticket.getLottoPrize());
    }
}
