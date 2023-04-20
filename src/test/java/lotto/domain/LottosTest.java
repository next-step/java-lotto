package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("Lotto 발급 테스트")
    void lottosTest() {
        Lottos lottos = Lottos.initLottos(Money.initMoney(5000));

        assertThat(lottos.getLottoQuantity())
                .isEqualTo(5);
    }

}