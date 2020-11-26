package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCounterTest {
    @Test
    @DisplayName("수동 로또 개수가 전체 금액을 넘을 때")
    void createPurchase_manualLottoCountOverMoney() {
        assertThatThrownBy(() ->
                new LottoCounter(10000, 11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("money and manual lotto count is wrong");
    }

    @Test
    @DisplayName("구입 금액에 맞는 로또 개수 계산")
    void getLottoNum() {
        int money = 14000;

        int lottoNum = LottoCounter.getLottoCount(money);

        assertThat(lottoNum).isEqualTo(14);
    }
}