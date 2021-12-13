package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void buyLottos_with_money() {
        // given
        long inputMoney = 6000;

        // when
        Lottos lottos = LottoMachine.buyLottos(inputMoney);

        // then
        assertThat(lottos.count()).isEqualTo(6);
    }

}
