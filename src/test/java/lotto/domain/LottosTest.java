package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottosTest {

    @Test
    @DisplayName("로또 생성")
    void testCreateLottos() {
        // given
        int size = 14;
        // when
        Lottos lottos = new Lottos(size);
        // then
        assertThat(lottos.size()).isEqualTo(0);
    }

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
        assertThat(lottos.getPurchaseAmount()).isEqualTo(money);
    }

    @Test
    @DisplayName("로또 당첨 결과")
    void testLottoResult() {
        // given
        Lottos lottos = new Lottos(1);
        lottos.add(Lotto.of("1,2,3,4,5,6"));
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,14,15,16"));
        // when
        LottoResult result = lottos.getLottoResult(winningLotto);
        // then
        assertThat(result.getYield()).isEqualTo(5.0);

    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    @DisplayName("로또 금액이 0이거나 0보다 적은 경우 예외")
    void testInvalidPurchaseMoney(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> Lottos.purchase(money));
    }

    @Test
    @DisplayName("로또 금액이 1000원 단위가 아닐 경우 예외")
    void testPurchaseLottoWithoutUnit() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lottos.purchase(500));
    }
}
