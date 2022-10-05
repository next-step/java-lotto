package lotto.step2.dto;

import lotto.step2fixture.dto.PaymentPriceDTOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentPriceDTOTest {
    @Test
    @DisplayName("지불 금액 확인")
    void getPaymentPrice() {
        assertThat(PaymentPriceDTOFixture.PAYMENT_PRICE_DTO.getPaymentPrice()).isEqualTo(14000);
    }
}