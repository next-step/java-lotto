package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 구매")
    void testPurchaseLotto() {
        // given
        int money = 10000;
        // when
        Lottos lottos = LottoMachine.purchase(money);
        // then
        assertThat(lottos.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 가격 계산")
    void testCalculateHowMuch() {
        assertThat(LottoMachine.calculateHowMuch(10)).isEqualTo(10000);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    @DisplayName("로또 금액이 0이거나 0보다 적은 경우 예외")
    void testInvalidPurchaseMoney(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoMachine.purchase(money));
    }

    @Test
    @DisplayName("로또 금액이 1000원 단위가 아닐 경우 예외")
    void testPurchaseLottoWithoutUnit() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoMachine.purchase(500));
    }
}
