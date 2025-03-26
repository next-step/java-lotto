package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.LottoPriceException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    @Test
    @DisplayName("로또 구매 금액에 따라 올바른 수의 로또를 생성하는지 테스트")
    void testGetLottos() {
        int money = 5000;
        LottoMachine lottoMachine = new LottoMachine(money);

        List<Lotto> lottos = lottoMachine.getLottos();

        assertThat(lottos).hasSize(5)
            .allSatisfy(lotto -> assertThat(lotto).isNotNull());
    }

    @Test
    @DisplayName("로또 가격으로 나누어 떨어지지 않는 금액으로 구매 시 테스트")
    void testGetLottosWithOddMoney() {
        int money = 1500;

        assertThatThrownBy(() -> new LottoMachine(money))
            .isInstanceOf(LottoPriceException.class);
    }

    @Test
    @DisplayName("로또 구매 금액이 로또 가격보다 적을 때 테스트")
    void testGetLottosWithInsufficientMoney() {
        int money = 500;

        assertThatThrownBy(() -> new LottoMachine(money))
            .isInstanceOf(LottoPriceException.class);
    }
}
