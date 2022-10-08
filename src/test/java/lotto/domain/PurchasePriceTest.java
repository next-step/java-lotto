package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.exception.NegativePriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {

    @Test
    @DisplayName("금액 객체 생성")
    void init_purchase_price() {
        assertThat((new PurchasePrice(1000)).getPrice())
                .isEqualTo(1000);
    }

    @Test
    @DisplayName("음수인 금액으로 금액 객체 생성 시 예외 발생")
    void fail_to_init_purchase_price_by_negative_price() {
        assertThatExceptionOfType(NegativePriceException.class)
                .isThrownBy(() -> new PurchasePrice(-1000));
    }

}
