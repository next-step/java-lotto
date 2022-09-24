package lotto.step2.domain.dto;

import lotto.step2.domain.PaymentPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PaymentPriceDTOTest {
    
    @Test
    @DisplayName("지불 금액 확인")
    void getPaymentPrice() {
        PaymentPriceDTO paymentPriceDTO = new PaymentPriceDTO(new PaymentPrice(14000));
        assertThat(paymentPriceDTO.getPaymentPrice()).isEqualTo(14000);
    }
}