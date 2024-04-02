package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoShopTest {
    @Test
    void 구매_개수() {
        int money = 3000;
        assertThat(new LottoShop(money).calculatePurchaseCount()).isEqualTo(3);
    }

    @Test
    void 구매_금액_오류() {
        int money = 3500;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoShop(money))
                .withMessageMatching("구매 금액은 1000원 단위로 입력해주세요.");
    }
}
