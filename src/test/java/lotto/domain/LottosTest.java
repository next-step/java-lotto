package lotto.domain;

import lotto.util.LottoExchanger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("자동 추첨 수량 확인")
    void autoPick() {
        // given
        Integer purchasePrice = 14000;

        // when
        Lottos lottos = LottoExchanger.purchaseLottos(purchasePrice);
        Lottos autoPickLottos = lottos.autoPick();

        // then
        assertThat(autoPickLottos.getLottoList()).hasSize(14);
    }
}
