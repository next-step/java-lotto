package lotto.shop;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.machine.TestLottoGenerator;
import lotto.domain.shop.LottoShop;
import lotto.domain.shop.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    @DisplayName("구입 금액이 음수이면, 예외를 발생시킨다.")
    void lottoShopNegativeBalanceTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoShop(new Money(-3000), new TestLottoGenerator(0)))
                .withMessage("금액은 음수일 수 없습니다.");
    }
}
