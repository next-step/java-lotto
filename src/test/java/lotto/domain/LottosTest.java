package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottosTest {

    @Test
    @DisplayName("자동 번호 선택")
    void testFillAutoRemaining() {
        // given
        int size = 14;
        // when
        Lottos lottos = new Lottos(size);
        lottos.fillAutoRemaining();
        // then
        assertThat(lottos.size()).isEqualTo(size);
    }

    @Test
    @DisplayName("로또 구매")
    void testPurchaseLotto() {
        // given
        int money = 10000;
        // when
        Lottos lottos = Lottos.purchase(money);
        // then
        assertThat(lottos.size()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    @DisplayName("로또 금액이 0이거나 0보다 적은 경우 예외")
    void testInvalidPurchaseMoney(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> Lottos.purchase(money));
    }
}
