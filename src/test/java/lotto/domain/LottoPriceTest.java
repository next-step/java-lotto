package lotto.domain;

import static lotto.domain.LottoPrice.CAN_NOT_BUY_LOTTO;
import static lotto.domain.LottoPrice.CAN_NOT_BUY_LOTTO_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPriceTest {
    @DisplayName("로또 금액 0이하")
    @Test
    void 로또_금액_0이하_에러() {
        assertThatThrownBy(() -> {
            new LottoPrice(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAN_NOT_BUY_LOTTO);
    }

    @DisplayName("로또 금액 1000단위 아닌 에러")
    @Test
    void 로또_금액_1000단위_에러() {
        assertThatThrownBy(() -> {
            new LottoPrice(1001);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAN_NOT_BUY_LOTTO_AMOUNT);
    }
}
