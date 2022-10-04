package lotto.step2.dto;

import lotto.step2.domain.PaymentPriceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentPriceDTOTest {
    public static final PaymentPriceDTO PAYMENT_PRICE_DTO = new PaymentPriceDTO(PaymentPriceTest.PAYMENT_PRICE);
    
    @Test
    @DisplayName("지불 금액 확인")
    void getPaymentPrice() {
        assertThat(PAYMENT_PRICE_DTO.getPaymentPrice()).isEqualTo(14000);
    }
}