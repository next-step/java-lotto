package lotto.util;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoExchangerTest {

    @Test
    @DisplayName("로또 교환기")
    void purchaseLottos() {
        // given
        Integer purchasePrice = 14000;

        // when
        Lottos lottos = LottoExchanger.purchaseLottos(14000);

        // then
    }
}
