package edu.nextstep.lottoauto.ticketmaker;

import edu.nextstep.lottoauto.domain.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutoTicketMakerTest {

    @Test
    @DisplayName("숫자 List 생성 Test")
    void create() {
        // given
        TicketMaker ticketMaker = new AutoTicketMaker();

        // when
        Ticket ticket = ticketMaker.create();

        // then
        Assertions.assertThat(ticket).isInstanceOf(Ticket.class);
    }
}
