package lotto.domain;

import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.LottoMoney;
import lotto.domain.machine.LottoTickets;
import lotto.infrastructure.AutoLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("로또 게임에 로또 금액을 입력하면 로또 티켓 묶음을 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {10000, 50000})
    public void buyLottoGameTest(int money) {
        LottoMoney lottoMoney = new LottoMoney(money);

        LottoMachine lottoMachine = new LottoMachine(lottoMoney);

        LottoTickets lottoTickets = lottoMachine.buy(new AutoLottoNumberStrategy());

        assertThat(lottoTickets).isNotNull();
    }

    @DisplayName("각각의 로또 게임은 같은 금액을 입력했어도 다른 게임으로 취급한다")
    @Test
    public void createLottoGameSameMoneyTest() {
        LottoMoney lottoMoney = new LottoMoney(1000);
        LottoMachine lottoMachine = new LottoMachine(lottoMoney);
        LottoMachine otherLottoMachine = new LottoMachine(lottoMoney);

        assertThat(lottoMachine).isNotEqualTo(otherLottoMachine);
    }

}
