package edu.nextstep.lottoauto.ticket;

import edu.nextstep.lottoauto.ticketManager.WinningNumbers;
import edu.nextstep.lottoauto.strategy.TicketMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TicketTest {

    @Test
    void create() {
        // given
        TicketMaker ticketMaker = getCustomTicketMaker();

        // when
        Ticket ticket = Ticket.create(ticketMaker);

        // then
        Assertions.assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);

    }

    @Test
    void checkAndUpdateWinningPrize() {
        // given
        TicketMaker ticketMaker = getCustomTicketMaker();
        Ticket ticket = Ticket.create(ticketMaker);
        WinningNumbers winningNumbers = WinningNumbers.from(new int[]{1, 2, 3, 4, 5, 6});

        // when
        ticket.checkAndUpdateWinningPrize(winningNumbers);

        // then
        Assertions.assertThat(ticket.getPrize()).isEqualTo(Prize.SIX);

    }

    private TicketMaker getCustomTicketMaker() {
        return () -> {
            List<Integer> ticketTmp = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                ticketTmp.add(i);
            }
            return new Ticket(ticketTmp);
        };
    }
}