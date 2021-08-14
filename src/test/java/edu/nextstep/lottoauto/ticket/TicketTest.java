package edu.nextstep.lottoauto.ticket;

import edu.nextstep.lottoauto.ticketManager.WinningNumbers;
import edu.nextstep.lottoauto.strategy.NumberMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TicketTest {

    @Test
    void create() {
        // given
        NumberMaker numberMaker = getCustomTicketMaker();

        // when
        Ticket ticket = Ticket.create(numberMaker);

        // then
        Assertions.assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);

    }

    @Test
    void checkAndUpdateWinningPrize() {
        // given
        NumberMaker numberMaker = getCustomTicketMaker();
        Ticket ticket = Ticket.create(numberMaker);
        WinningNumbers winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6");

        // when
        ticket.checkAndUpdateWinningPrize(winningNumbers);

        // then
        Assertions.assertThat(ticket.getPrize()).isEqualTo(Prize.SIX);

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