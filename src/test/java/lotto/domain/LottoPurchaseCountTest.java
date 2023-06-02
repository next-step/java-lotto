package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoPurchaseCountTest {

    @Test
    @DisplayName("[요구사항 1] 구매하고자 하는 금액이 실 구입 금액보다 클 경우 IllegalArgumentException throw")
    void 요구사항_1() {
        // given
        int requestPurchaseAmount = 10_000;
        int requestManuallyPurchaseCount = 15;

        // then
        assertThatThrownBy(() -> new LottoPurchaseCount(requestPurchaseAmount, requestManuallyPurchaseCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매하고자 하는 금액이 구입 금액보다 클 수 없습니다.");
    }

    @Test
    @DisplayName("[요구사항 2] 10,000원을 가지고 수동 로또 5장을 구입하였을 경우, 자동 로또는 5장 구매")
    void 요구사항_2() {
        // given: purchaseAmount(구입 금액) 및 기대 결과 제시
        int requestPurchaseAmount = 10_000;
        int requestManuallyPurchaseCount = 5;
        int expectedResult = 5;

        // then
        LottoPurchaseCount lottoPurchaseCount = new LottoPurchaseCount(requestPurchaseAmount, requestManuallyPurchaseCount);
        assertThat(lottoPurchaseCount.getAutomaticallyPurchaseCount()).isEqualTo(expectedResult);
    }
}
