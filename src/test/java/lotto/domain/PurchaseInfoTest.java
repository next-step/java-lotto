package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseInfoTest {

    @Test
    @DisplayName("로또를 구매한 금액과 수동으로 구매한 개수를 입력했을 때 자동 구매한 개수를 성공적으로 반환하는지 확인한다")
    void 자동_구매_정보_확인() {
        PurchaseInfo purchaseInfo = new PurchaseInfo(10000, 3);

        Assertions.assertThat(purchaseInfo.getNumberOfAutoPurchase()).isEqualTo(7);
    }

    @Test
    @DisplayName("로또를 구매한 금액과 수동으로 구매한 개수를 입력했을 때 수동 구매한 개수를 성공적으로 반환하는지 확인한다")
    void 수동_구매_정보_확인() {
        PurchaseInfo purchaseInfo = new PurchaseInfo(10000, 3);

        Assertions.assertThat(purchaseInfo.getNumberOfManualPurchase()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또를 구매한 금액과 수동으로 구매한 개수를 입력했을 때 전체 구매 금액을 성공적으로 반환하는지 확인한다")
    void 전체_구매_금액_확인() {
        PurchaseInfo purchaseInfo = new PurchaseInfo(10000, 3);

        Assertions.assertThat(purchaseInfo.getPruchaseAmount()).isEqualTo(10000);
    }

}
