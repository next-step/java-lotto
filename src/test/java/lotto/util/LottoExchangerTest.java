package lotto.util;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoExchangerTest {

    @Test
    @DisplayName("로또 교환기 생성 확인")
    void purchaseLottos() {
        // given
        Integer purchasePrice = 14000;

        // when
        Lottos lottos = LottoExchanger.purchaseLottos(purchasePrice);

        // then
        assertThat(lottos).isEqualTo(new Lottos(14, purchasePrice));
    }
}
