package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.exception.PaymentIllegalArgumentException;
import edu.nextstep.lottoauto.domain.ticketmaker.AutoNumbersMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TicketMachineTest {

    private static final int TICKET_PRICE = 1_000;

    @BeforeEach
    void removeAll(){
        TicketRepository.removeAll();
    }

    @Test
    @DisplayName("Tickets 생성")
    void createAndSaveTickets() {
        // given
        int payment = 10000;
        TicketMachine ticketMachine = new TicketMachine();

        // when
        ticketMachine.createAndSaveTickets(payment, new AutoNumbersMaker());

        // then
        assertThat(TicketRepository.findAll().size()).isEqualTo(payment/TICKET_PRICE);
        assertThat(TicketRepository.findAll().get(0)).isInstanceOf(Ticket.class);
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
}
