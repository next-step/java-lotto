package edu.nextstep.lottoauto.manager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketManagerTest {

    @Test
    @DisplayName("금액 입력 시 실행 횟수 반환")
    void calculateNumberOfTicketsFrom() {
        // given
        int payment = 14_000;
        TicketManager ticketManager = new TicketManager();

        // when
        int numberOfTickets = ticketManager.calculateNumberOfTicketsFrom(payment);

        // then
        Assertions.assertThat(numberOfTickets).isEqualTo(payment);
    }

    @ParameterizedTest(name = "금액 검증 실패 : 1000원 미만")
    @ValueSource(ints = {1, 999})
    void validate_calculateNumberOfTicketsFrom_단위(int payment) {
        // given
        TicketManager ticketManager = new TicketManager();

        // when
        Assertions.assertThatThrownBy(() -> ticketManager.calculateNumberOfTicketsFrom(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "금액 검증 실패 : 1000원 단위 떨어지지 않음")
    @ValueSource(ints = {1001, 1999})
    void validate_calculateNumberOfTicketsFrom_1000미만(int payment) {
        /// given
        TicketManager ticketManager = new TicketManager();

        // when, then
        Assertions.assertThatThrownBy(() -> ticketManager.calculateNumberOfTicketsFrom(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest(name = "숫자 개수 실패 {index}_{0}")
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"}) // given
    void validate_number_of_numbers(String winningNumbersString) {
        // given
        TicketManager ticketManager = new TicketManager();

        // then
        assertThatThrownBy(() -> ticketManager.createNumbersFromString(winningNumbersString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "숫자 허용 범위 실패 {index}_{0}")
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "41, 42, 43, 44, 45, 46"}) // given
    void validate_fail_out_of_range(String winningNumbersString) {
        // given
        TicketManager ticketManager = new TicketManager();

        // then
        assertThatThrownBy(() -> ticketManager.createNumbersFromString(winningNumbersString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}