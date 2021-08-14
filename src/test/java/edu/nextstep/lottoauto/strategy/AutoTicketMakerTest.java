package edu.nextstep.lottoauto.strategy;

import edu.nextstep.lottoauto.ticket.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutoTicketMakerTest {

    @BeforeEach
    void initTotalNumbers(){
        AutoTicketMaker.sortTotalNumbers();
    }

    @Test
    void makeTicket() {
        // given
        AutoTicketMaker autoTicketMaker = new AutoTicketMaker(){
            @Override
            protected void flushingTotalNumbers() {
            }
        };

        // when
        Ticket ticket = autoTicketMaker.makeTicket();

        // then
        Assertions.assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);

    }

}