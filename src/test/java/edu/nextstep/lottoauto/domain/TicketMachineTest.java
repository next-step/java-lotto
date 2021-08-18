package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.exception.PaymentIllegalArgumentException;
import edu.nextstep.lottoauto.view.form.WinningResultForm;
import edu.nextstep.lottoauto.domain.ticketmaker.AutoNumbersMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketMachineTest {

    private static final int TICKET_PRICE = 1_000;


    @Test
    @DisplayName("Tickets 생성")
    void createAndSaveTickets() {
        // given
        int payment = 10000;
        TicketMachine ticketMachine = new TicketMachine();

        // when
        ticketMachine.createAndSaveTickets(payment, new AutoNumbersMaker());

        // then
        assertThat(ticketMachine.findTickets().size()).isEqualTo(payment/TICKET_PRICE);
        assertThat(ticketMachine.findTickets().get(0)).isInstanceOf(Ticket.class);
    }

    @Test
    @DisplayName("Custom Ticket 생성")
    void createCustomTicket() {
        // given
        String numbersOfString = "1, 2, 3, 4, 5, 6";
        TicketMachine ticketMachine = new TicketMachine();

        // when
        Ticket ticket = ticketMachine.createCustomTicket(numbersOfString);

        // then
        assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }


    @Test
    @DisplayName("당첨 결과 확인")
    void checkWinningResult() {
        // given
        TicketMachine ticketMachine = new TicketMachine();
        ticketMachine.createAndSaveTickets(1000, () -> createNumbersFromTo(1,6));

        // when
        WinningResultForm winningResult =
                ticketMachine.confirmWinningResult(Ticket.madeBy(() -> createNumbersFromTo(4,9)));

        // then
        assertThat(winningResult.getWinningResult().getOrDefault(Prize.FOURTH,0)).isEqualTo(1);
        assertThat(winningResult.getRateOfReturn()).isEqualTo(5);
    }

    @Test
    @DisplayName("금액 입력 시 실행 횟수 반환")
    void calculateNumberOfTicketsFrom() {
        // given
        int payment = 14_000;
        TicketMachine ticketMachine= new TicketMachine();

        // when
        int numberOfTickets = ticketMachine.calculateNumberOfTicketsFrom(payment);

        // then
        assertThat(numberOfTickets).isEqualTo(payment/TICKET_PRICE);
    }

    @ParameterizedTest(name = "금액 검증 실패 : 1000원 미만")
    @ValueSource(ints = {1, 999})
    void validate_createAndSaveTickets_단위(int payment) {
        // given
        TicketMachine ticketMachine = new TicketMachine();

        // when
        assertThatThrownBy(() -> ticketMachine.createAndSaveTickets(payment, new AutoNumbersMaker()))
                .isInstanceOf(PaymentIllegalArgumentException.class)
                .hasMessageContaining("최소 입력 가능 금액 미달.");
    }

    @ParameterizedTest(name = "금액 검증 실패 : 1000원 단위 떨어지지 않음")
    @ValueSource(ints = {1001, 1999})
    void validate_createAndSaveTickets_1000미만(int payment) {
        /// given
        TicketMachine ticketMachine = new TicketMachine();

        // when, then
        assertThatThrownBy(() -> ticketMachine.createAndSaveTickets(payment, new AutoNumbersMaker()))
                .isInstanceOf(PaymentIllegalArgumentException.class)
                .hasMessageContaining("개 당 금액");
    }

    private List<Integer> createNumbersFromTo(int numFrom, int numTo) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = numFrom; i <= numTo; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
