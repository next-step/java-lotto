package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.exception.PaymentIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentTest {

    @ParameterizedTest(name = "금액 검증 실패 : " + Payment.TICKET_PRICE + "원 미만")
    @ValueSource(ints = {1, Payment.TICKET_PRICE-1})
    void create_fail_under_unit_price(int payment) {
        // when
        assertThatThrownBy(() -> new Payment(payment))
                .isInstanceOf(PaymentIllegalArgumentException.class)
                .hasMessageContaining(Payment.UNDER_UNIT_PRICE_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest(name = "금액 검증 실패 : " + Payment.TICKET_PRICE + "원 단위 떨어지지 않음")
    @ValueSource(ints = {Payment.TICKET_PRICE+1, 2*Payment.TICKET_PRICE-1})
    void create_divide_unit_price(int payment) {
        // when, then
        assertThatThrownBy(() -> new Payment(payment))
                .isInstanceOf(PaymentIllegalArgumentException.class)
                .hasMessageContaining(Payment.DIVIDE_UNIT_PRICE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("수동 복권 개수 생성 가능량 초과에 대한 검증")
    void validateOverPossibleTickets() {
        // given
        int inputPayment = 10_000;
        int numberOfCustomTickets = 11;
        Payment payment = new Payment(inputPayment);

        // when, then
        assertThatThrownBy(() -> payment.validateOverPossibleTickets(numberOfCustomTickets))
                .isInstanceOf(PaymentIllegalArgumentException.class)
                .hasMessageContaining(Payment.OVER_POSSIBLE_TICKETS_EXCEPTION_MESSAGE);
    }
}
