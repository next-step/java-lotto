package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PurchaseNumberCalculationTest {

    @DisplayName(value = "금액을 천단위로 입력하지 않으면 예외")
    @ParameterizedTest
    @ValueSource(ints = {1_001, 9_999, 10_001})
    void 금액_단위(int purchasePrice) {
        assertThatThrownBy(() -> {
            // when
            PurchaseNumberCalculation.calculateNumberPurchase(purchasePrice);
        // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "금액을 천원미만으로 입력하면 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    void 최소_금액(int purchasePrice) {
        assertThatThrownBy(() -> {
            // when
            PurchaseNumberCalculation.calculateNumberPurchase(purchasePrice);
            // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "장당 천원으로 계산하여 구매 티켓 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1000, 1", "7000, 7", "40000, 40"})
    void 구매_티켓_술(int purchasePrice, int expect) {
        // when
        int purchaseCount = PurchaseNumberCalculation.calculateNumberPurchase(purchasePrice);

        // then
        assertThat(purchaseCount).isEqualTo(expect);
    }
}