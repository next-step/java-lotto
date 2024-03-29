package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoShopTest {
    @Test
    void 구매_수() {
        assertThat(LottoShop.countPurchase(3000)).isEqualTo(3);
    }

    @Test
    void 구매금액_오류() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoShop.purchaseTicket(3500))
                .withMessageMatching("구매 금액은 1000 단위로 입력해야 합니다.");
    }
}
