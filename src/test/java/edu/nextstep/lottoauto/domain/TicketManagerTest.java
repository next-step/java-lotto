package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.exception.PaymentIllegalArgumentException;
import edu.nextstep.lottoauto.domain.ticketmaker.AutoNumbersMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TicketManagerTest {

    private static final int A_UNIT_PRICE = 1_000;

    @Test
    @DisplayName("금액 입력 시 실행 횟수 반환")
    void calculateNumberOfTicketsFrom() {
        // given
        int payment = 14_000;
        TicketManager ticketManager = new TicketManager();

        // when
        int numberOfTickets = ticketManager.calculateNumberOfTicketsFrom(payment);

        // then
        assertThat(numberOfTickets).isEqualTo(payment/A_UNIT_PRICE);
    }

    @ParameterizedTest(name = "금액 검증 실패 : 1000원 미만")
    @ValueSource(ints = {1, 999})
    void validate_createAndSaveTickets_단위(int payment) {
        // given
        TicketManager ticketManager = new TicketManager();

        // when
        assertThatThrownBy(() -> ticketManager.createAndSaveTickets(payment, new AutoNumbersMaker()))
                .isInstanceOf(PaymentIllegalArgumentException.class)
                .hasMessageContaining("최소 입력 가능 금액 미달.");
    }

    @ParameterizedTest(name = "금액 검증 실패 : 1000원 단위 떨어지지 않음")
    @ValueSource(ints = {1001, 1999})
    void validate_createAndSaveTickets_1000미만(int payment) {
        /// given
        TicketManager ticketManager = new TicketManager();

        // when, then
        assertThatThrownBy(() -> ticketManager.createAndSaveTickets(payment, new AutoNumbersMaker()))
                .isInstanceOf(PaymentIllegalArgumentException.class)
                .hasMessageContaining("개 당 금액");
    }
}