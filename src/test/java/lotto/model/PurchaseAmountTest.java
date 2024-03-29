package lotto.model;

import lotto.exception.PurchaseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @Test
    @DisplayName("정상적인 구매 금액")
    void testPurchaseAmount_ShouldReturnCorrectResult() {
        // given, when
        PurchaseAmount purchaseAmount = new PurchaseAmount(4000);

        // then
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(4000);
        assertThat(purchaseAmount.getNumberOfTotalLottos()).isEqualTo(4);
    }

    @Test
    @DisplayName("비정상적인 수동로또 구매 개수")
    void testPurchaseAmount_InvalidNumberOfManualLottos_ShouldThrowException() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);

        // when, then
        assertThatThrownBy(() -> purchaseAmount.isValidPurchaseNumberOfManualLotto(10))
                .isInstanceOf(PurchaseException.class);
    }

    @ParameterizedTest(name = "비정상적인 구매 금액 (0원 이하의 금액)")
    @ValueSource(ints = {-1000, 999, 0})
    void testPurchaseAmount_InvalidPurchaseAmount_ShouldThrowException(int input) {
        // when, then
        assertThatThrownBy(() -> new PurchaseAmount(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
