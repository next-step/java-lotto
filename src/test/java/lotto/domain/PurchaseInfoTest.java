package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseInfoTest {

    @Test
    @DisplayName("로또를 구매한 금액과 수동으로 구매한 개수를 입력했을 때 자동 구매한 개수를 성공적으로 반환하는지 확인한다")
    void 자동_구매_정보_확인() {
        PurchaseInfo purchaseInfo = new PurchaseInfo(10000, 3);

        assertThat(purchaseInfo.getNumberOfAutoPurchase()).isEqualTo(7);
    }

    @Test
    @DisplayName("로또를 구매한 금액과 수동으로 구매한 개수를 입력했을 때 수동 구매한 개수를 성공적으로 반환하는지 확인한다")
    void 수동_구매_정보_확인() {
        PurchaseInfo purchaseInfo = new PurchaseInfo(10000, 3);

        assertThat(purchaseInfo.getNumberOfManualPurchase()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또를 구매한 금액과 수동으로 구매한 개수를 입력했을 때 전체 구매 금액을 성공적으로 반환하는지 확인한다")
    void 전체_구매_금액_확인() {
        PurchaseInfo purchaseInfo = new PurchaseInfo(10000, 3);

        assertThat(purchaseInfo.getPruchaseAmount()).isEqualTo(10000);
    }

    @Test
    @DisplayName("1000원 미만 입력 시 예외 발생")
    void 로또_구매_불가_1000원_미만(){
        Assertions.assertThatThrownBy(() ->
                new PurchaseInfo(999, 2)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 미만으론 살 수 없음");
    }

}
