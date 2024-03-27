package autoLotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPurchaseCountTest {
    private static final String INVALID_NUMBER_OF_PURCHASE_COUNT = "전체 구매 로또의 수보다 수동 로또의 개수, 또는 자동 로또의 개수가 많을 수 없습니다.";

    @Test
    void testLottoPurchaseCount_ShouldReturnCorrectPurchaseCount() {
        // given
        int purchaseAmount = 4000;
        int numberOfManualLottos = 1;

        // when
        LottoPurchaseCount purchaseCount = new LottoPurchaseCount(purchaseAmount, numberOfManualLottos);

        // then
        assertEquals(purchaseCount.getNumberOfAutoLottos(), 3);
    }

    @Test
    void testLottoPurchaseCount_InvalidNumberOfManualLottos_ShouldReturnCorrectPurchaseCount() {
        // given
        int purchaseAmount = 4000;
        int numberOfManualLottos = 10;

        // when, then
        assertThatThrownBy(() -> new LottoPurchaseCount(purchaseAmount, numberOfManualLottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_OF_PURCHASE_COUNT);
    }
}
