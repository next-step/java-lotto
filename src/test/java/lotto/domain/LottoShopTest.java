package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoShop.buyLotto;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoShopTest {

    @Test
    @DisplayName(value = "입력 금액이 천원 이하일 경우")
    void test1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            buyLotto(900);
        });
    }
}
