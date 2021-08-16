package edu.nextstep.lottoauto.machine;

import edu.nextstep.lottoauto.domain.Prize;
import edu.nextstep.lottoauto.domain.Ticket;
import edu.nextstep.lottoauto.form.WinningResultForm;
import edu.nextstep.lottoauto.ticketmaker.AutoTicketMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketMachineTest {

    @Test
    @DisplayName("Tickets 생성")
    void createAndSaveTickets() {
        // given
        int numberOfTicket = 10;
        TicketMachine ticketMachine = new TicketMachine();

        // when
        ticketMachine.createAndSaveTickets(numberOfTicket, new AutoTicketMaker());

        // then
        assertThat(ticketMachine.findTickets().size()).isEqualTo(numberOfTicket);
        assertThat(ticketMachine.findTickets().get(0)).isInstanceOf(Ticket.class);
    }

    @Test
    @DisplayName("당첨 결과 확인")
    void checkWinningResult() {
        // given
        TicketMachine ticketMachine = new TicketMachine();
        ticketMachine.createAndSaveTickets(1, () -> Ticket.of(createNumbersFromTo(1,6)));

        // when
        WinningResultForm winningResult = ticketMachine.confirmWinningResult(createNumbersFromTo(4,9));

        // then
        assertThat(winningResult.getWinningResult().get(Prize.FOURTH)).isEqualTo(1);
        assertThat(winningResult.getRateOfReturn()).isEqualTo(5);
    }

    private List<Integer> createNumbersFromTo(int numFrom, int numTo) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = numFrom; i <= numTo; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
