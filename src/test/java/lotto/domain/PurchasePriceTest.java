package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.exception.NegativePriceException;
import lotto.domain.exception.NullPurchasePriceException;
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

    @Test
    @DisplayName("금액 빼기.")
    void subtract_price() {
        PurchasePrice purchasePrice = PurchasePrice.subtractPrice(new PurchasePrice(3000),
                new PurchasePrice(1000));
        assertThat(purchasePrice.getPrice())
                .isEqualTo(2000);
    }

    @Test
    @DisplayName("금액 빼기 시 null 이 있으면 예외 발생")
    void fail_to_subtract_price_by_null_purchase_price() {
        assertThatExceptionOfType(NullPurchasePriceException.class)
                .isThrownBy(() -> PurchasePrice.subtractPrice(null, new PurchasePrice(1000)));
    }

    @Test
    @DisplayName("금액 빼기 결과로 음수가 나오면 예외 발생")
    void fail_to_subtract_price_when_result_is_negative_price() {
        assertThatExceptionOfType(NegativePriceException.class)
                .isThrownBy(() -> PurchasePrice.subtractPrice(new PurchasePrice(1000),
                        new PurchasePrice(3000)));
    }

}
