/*
 * TicketMakerTest.java
 *
 * v0.1 ,  2021.08.14
 */

package edu.nextstep.lottoauto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TicketMakerTest {

    @Test
    void create() {
        // given, when
        List<Integer> checkList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            checkList.add(i);
        }

        // then
        Assertions.assertThat(TicketMaker.getTotalNumbers()).isEqualTo(checkList);
    }

    @Test
    void makeTickets() {
        // given
        int payment = 14_000;

        // when
        TicketMaker ticketMaker = TicketMaker.create();
        List<List<Integer>> lottoTickets = ticketMaker.makeTickets(payment);

        // then
        Assertions.assertThat(lottoTickets.size()).isEqualTo(14);
        Assertions.assertThat(lottoTickets.get(0).size()).isEqualTo(6);
    }
}
