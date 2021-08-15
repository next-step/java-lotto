package edu.nextstep.lottoauto.ticketManager;

import edu.nextstep.lottoauto.strategy.AutoNumberMaker;
import edu.nextstep.lottoauto.strategy.NumberMaker;
import edu.nextstep.lottoauto.ticket.Prize;
import edu.nextstep.lottoauto.ticket.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        ticketManager.createTickets(payment, new AutoNumberMaker());

        // then
        assertThat(ticketManager.getTickets().size()).isEqualTo(payment / 1_000);
        assertThat(ticketManager.getTickets().get(0)).isInstanceOf(Ticket.class);
    }

    @ParameterizedTest(name = "createTickets_validateMinPayment_fail {index} : {0}")
    @ValueSource(ints = {-1, 999}) // given
    void createTickets_validateMinPayment_fail(int payment) {
        // when
        TicketManager ticketManager = new TicketManager();

        // then
        assertThatThrownBy(() -> ticketManager.createTickets(payment, getCustomTicketMaker()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 금액은");
    }

    @ParameterizedTest(name = "createTickets_validateBeDivisibleByPrice_fail {index} : {0}")
    @ValueSource(ints = {1001, 1999}) // given
    void createTickets_validateBeDivisibleByPrice_fail(int payment) {
        // when
        TicketManager ticketManager = new TicketManager();

        // then
        assertThatThrownBy(() -> ticketManager.createTickets(payment, getCustomTicketMaker()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("단위 입력");
    }

    @Test
    void makeWinningPrizeResult() {
        // given
        int payment = 14_000;
        TicketManager ticketManager = new TicketManager();
        NumberMaker numberMaker = getCustomTicketMaker();
        ticketManager.createTickets(payment, numberMaker);
        ticketManager.setWinningNumbersFrom("1, 2, 3, 4, 5, 6");

        // when
        WinningPrizeResult winningPrizeResult = ticketManager.makeWinningPrizeResult();

        // then
        assertThat(winningPrizeResult.getWinningPrizeResult().get(Prize.SIX)).isEqualTo(14);
        assertThat(winningPrizeResult.getWinningPrizeResult().get(Prize.THREE)).isNull();
    }

    private NumberMaker getCustomTicketMaker() {
        return () -> {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                numbers.add(i);
            }
            return numbers;
        };
    }

}