package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoShopTest {
    @Test
    void 총_구매_게수() {
        int money = 3000;
        int passiveCount = 2;
        assertThat(new LottoShop(money).calculateTotalPurchaseCount(passiveCount)).isEqualTo(3);
    }

    @Test
    void 자동_구매_개수() {
        int money = 3000;
        int passiveCount = 2;
        assertThat(new LottoShop(money).calculateTotalPurchaseCount(passiveCount) - passiveCount)
                .isEqualTo(1);
    }

    @Test
    void 수동_구매_개수_오류() {
        int money = 3000;
        int passiveCount = 4;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoShop(money).calculateTotalPurchaseCount(passiveCount))
                .withMessageMatching("구매 가능한 로또 수를 초과했습니다.");
    }

    @Test
    void 구매_금액_오류() {
        int money = 3500;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoShop(money))
                .withMessageMatching("구매 금액은 1000원 단위로 입력해주세요.");
    }
}
