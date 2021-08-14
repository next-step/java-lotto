package edu.nextstep.lottoauto.ticketManager;

import edu.nextstep.lottoauto.strategy.AutoTicketMaker;
import edu.nextstep.lottoauto.strategy.TicketMaker;
import edu.nextstep.lottoauto.ticket.Prize;
import edu.nextstep.lottoauto.ticket.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TicketManagerTest {

    @Test
    void createTickets() {
        // given
        int payment = 14_000;
        TicketManager ticketManager = new TicketManager();

        // when
        ticketManager.createTickets(payment, new AutoTicketMaker());

        // then
        assertThat(ticketManager.getTickets().size()).isEqualTo(payment / 1_000);
        assertThat(ticketManager.getTickets().get(0)).isInstanceOf(Ticket.class);
    }

    @Test
    void makeWinningPrizeResult() {
        // given
        int payment = 14_000;
        TicketManager ticketManager = new TicketManager();
        TicketMaker ticketMaker = getCustomTicketMaker();
        ticketManager.createTickets(payment, ticketMaker);
        ticketManager.setWinningNumbersFrom("1, 2, 3, 4, 5, 6");

        // when
        WinningPrizeResult winningPrizeResult = ticketManager.makeWinningPrizeResult();

        // then
        assertThat(winningPrizeResult.getWinningPrizeResult().get(Prize.SIX)).isEqualTo(1);
        assertThatThrownBy(() -> winningPrizeResult.getWinningPrizeResult().get(Prize.THREE))
                .isInstanceOf(NullPointerException.class);
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