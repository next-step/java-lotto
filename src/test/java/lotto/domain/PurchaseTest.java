package lotto.domain;

import lotto.domain.purchase.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {

    @Test
    @DisplayName("구매한 상품의 개수 테스트")
    void 구매_테스트() {
        int money = 1000;
        Purchase sale = new Purchase(money);

        assertThat(sale.purchase(money)).isEqualTo(1);
    }

    @Test
    @DisplayName("구매 생성자 에러 테스트 - 돈이 부족한 경우")
    void 구매_생성자_에러_테스트() {
        int money = 999;
        assertThatThrownBy(() -> new Purchase(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("돈이 부족합니다.");
    }

}
