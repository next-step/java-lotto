package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseInformationTest {

    @Test
    @DisplayName("가격과 수동 개수로 구매 정보를 구한다 (전체 로또 개수, 자동 로또 개수)")
    void purchaseInfoTest() {
        int price = 2000;
        int manualCount = 1;
        PurchaseInformation purchaseInfo = new PurchaseInformation(price, manualCount);

        assertThat(purchaseInfo.totalCount()).isEqualTo(2);
        assertThat(purchaseInfo.autoCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("수동 로또 개수가 전체 로또 개수보다 클 경우 예외가 발생한다")
    void validManualCountTest() {
        int price = 3000;
        int manualCount = 4;

        assertThatThrownBy(() -> new PurchaseInformation(price, manualCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
