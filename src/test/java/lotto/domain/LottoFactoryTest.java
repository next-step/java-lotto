package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @Test
    @DisplayName("로또를 금액만큼 생성한다")
    void create_Lottos() {
        // given
        int money = 1000;
        int expected = 1;

        // when
        Lottos lottos = LottoFactory.createLottos(money);

        // then
        assertEquals(expected, lottos.of().size());
    }

    @Test
    @DisplayName("금액이 부족하면 에러가 난다")
    void create_Lottos_exception() {
        // given
        int money = 999;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> LottoFactory.createLottos(money));
    }

}
