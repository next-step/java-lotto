package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PurchaseNumberCalculationTest {

    @ParameterizedTest
    @ValueSource(ints = {14000, 1000})
    void 구매_개수_반환(int purchase) {
        // when
        int numberPurchase = PurchaseNumberCalculation.calculateNumberPurchase(purchase);

        // then
        assertThat(numberPurchase).isEqualTo(purchase / 1000);
    }

    @DisplayName(value = "1000원 미만이면 예외")
    @Test
    void 천원_미만_일_때() {
        // given
        int purchase = 999;

        // then
        assertThatThrownBy(() -> {
            PurchaseNumberCalculation.calculateNumberPurchase(purchase);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "천 단위가 아니면 예외")
    @ParameterizedTest
    @ValueSource(ints = {1001, 1500})
    void 천_단위가_아닐_때(int purchase) {
        // then
        assertThatThrownBy(() -> {
            PurchaseNumberCalculation.calculateNumberPurchase(purchase);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}