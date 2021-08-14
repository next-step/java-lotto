/*
 * TicketMakerTest.java
 *
 * v0.1 ,  2021.08.14
 */

package edu.nextstep.lottoauto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TicketMakerTest {

    @Test
    void create() {
        // given
        int payment = 14_000;

        // when
        TicketMaker ticketMaker = TicketMaker.create();

        // then
        Assertions.assertThat(ticketMaker.getPricePerOneTicket()).isEqualTo(1000);
    }

    @Test
    void makeTickets() {
        // given
        int payment = 14_000;

        // when
        TicketMaker ticketMaker = TicketMaker.create();
        List<LottoTicket> lottoTickets = ticketMaker.makeTickets(payment);

        // then
        Assertions.assertThat(lottoTickets.size()).isEqualTo(14);
        Assertions.assertThat(lottoTickets.get(0).size()).isEqualTo(6);
    }
}
