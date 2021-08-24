package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.exception.PaymentIllegalArgumentException;
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
                .hasMessageContaining("최소 입력 가능 금액 미달.");
    }

    @ParameterizedTest(name = "금액 검증 실패 : " + Payment.TICKET_PRICE + "원 단위 떨어지지 않음")
    @ValueSource(ints = {Payment.TICKET_PRICE+1, 2*Payment.TICKET_PRICE-1})
    void create_divide_unit_price(int payment) {
        // when, then
        assertThatThrownBy(() -> new Payment(payment))
                .isInstanceOf(PaymentIllegalArgumentException.class)
                .hasMessageContaining("개 당 금액");
    }
}
