package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TicketTest {
    @Test
    public void 입력한_구입금액만큼_로또를_구매한다() {
        //given
        Ticket ticket = new Ticket(14000);

        //when

        //then
        assertThat(ticket.getBuyCount()).isEqualTo(14);
    }
}