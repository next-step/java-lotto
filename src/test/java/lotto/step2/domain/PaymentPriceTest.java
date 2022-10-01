package lotto.step2.domain;

import lotto.step2.domain.dto.PaymentPriceDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentPriceTest {
    public static final PaymentPrice PAYMENT_PRICE = new PaymentPrice(14000);
    
    @Test
    @DisplayName("입력된 금액에 따른 로또 티켓 수")
    void numberOfTickets() {
        assertThat(PAYMENT_PRICE.numberOfTickets()).isEqualTo(14);
    }
    
    @Test
    @DisplayName("지불 금액 확인")
    void checkPaymentPrice() {
        PaymentPriceDTO paymentPriceDTO = PAYMENT_PRICE.paymentPriceInformation();
        assertThat(paymentPriceDTO.getPaymentPrice()).isEqualTo(14000);
    }
}