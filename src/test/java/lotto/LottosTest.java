package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1, 0, 900, 999})
    @DisplayName("로또 구입 금액 부족")
    void buyLottoFailWhenNotEnoughMoney(int money) {
        assertThrows(IllegalArgumentException.class, () -> Lottos.buyLotto(money));
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1002, 1003})
    @DisplayName("로또 구입 금액은 1000원 단위여야 한다")
    void buyLottoFailWhenNotMultipleOf1000(int money) {
        assertThrows(IllegalArgumentException.class, () -> Lottos.buyLotto(money));
    }

    @Test
    @DisplayName("로또 구입 금액에 맞게 로또를 생성한다")
    void getLottoCount() {
        Lottos lottos = Lottos.buyLotto(14000);
        assertEquals(14, lottos.getLottoCount());
    }
}
