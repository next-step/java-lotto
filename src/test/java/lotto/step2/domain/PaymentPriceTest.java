package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentPriceTest {
    
    @Test
    @DisplayName("입력된 금액에 따른 로또 티켓 수")
    void numberOfTickets() {
        PaymentPrice paymentPrice = new PaymentPrice(5000);
        assertThat(paymentPrice.numberOfTickets()).isEqualTo(5);
    }
}