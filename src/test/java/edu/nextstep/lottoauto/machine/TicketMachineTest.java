package edu.nextstep.lottoauto.machine;

import edu.nextstep.lottoauto.domain.Prize;
import edu.nextstep.lottoauto.domain.Ticket;
import edu.nextstep.lottoauto.form.WinningResultForm;
import edu.nextstep.lottoauto.ticketmaker.AutoTicketMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        String winningNumbersString = "1, 2, 3, 4, 5, 6";
        TicketMachine ticketMachine = new TicketMachine();
        ticketMachine.createAndSaveTickets(
                1, () -> Ticket.of(createNumbersFromTo(1,6))
        );

        // when
        WinningResultForm winningResult = ticketMachine.confirmWinningResult(winningNumbersString);

        // then
        assertThat(winningResult.countNumberOf(Prize.FIRST)).isEqualTo(1);
    }

    @ParameterizedTest(name = "숫자 개수 실패 {index}_{0}")
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"}) // given
    void checkWinningResult_fail_number_of_numbers(String numbersOfString) {
        // given
        TicketMachine ticketMachine = new TicketMachine();
        ticketMachine.createAndSaveTickets(
                1, () -> Ticket.of(createNumbersFromTo(1,6))
        );

        // when, then
        assertThatThrownBy(() -> ticketMachine.confirmWinningResult(numbersOfString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "숫자 허용 범위 실패 {index}_{0}")
    @ValueSource(strings = {"-1, 1, 3, 4, 5, 45", "0, 1, 3, 4, 5, 45", "1, 3, 4, 5, 45, 46"}) // given
    void checkWinningResult_fail_out_of_range(String numbersOfString) {
        // given
        TicketMachine ticketMachine = new TicketMachine();
        ticketMachine.createAndSaveTickets(
                1, () -> Ticket.of(createNumbersFromTo(1,6))
        );

        // when, then
        assertThatThrownBy(() -> ticketMachine.confirmWinningResult(numbersOfString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Integer> createNumbersFromTo(int numFrom, int numTo) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = numFrom; i <= numTo; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
