package lotto.step2.domain;

import lotto.step2fixture.dto.PaymentPriceDTOFixture;
import lotto.step2fixture.domain.PaymentPriceFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentPriceTest {
    @Test
    @DisplayName("입력된 금액에 따른 로또 티켓 수")
    void numberOfTickets() {
        assertThat(PaymentPriceFixture.PAYMENT_PRICE.numberOfTickets()).isEqualTo(14);
    }
    
    @Test
    @DisplayName("지불 금액 확인")
    void checkPaymentPrice() {
        int paymentPrice = PaymentPriceDTOFixture.PAYMENT_PRICE_DTO.getPaymentPrice();
        assertThat(paymentPrice).isEqualTo(14000);
    }
}