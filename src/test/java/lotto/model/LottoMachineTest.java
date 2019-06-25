package lotto.model;

import lotto.exception.MinimumAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("잔액 부족으로 로또 구매 실패")
    @Test
    void buyLottoFail() {
        assertThatExceptionOfType(MinimumAmountException.class)
                .isThrownBy(() -> lottoMachine.buyLotto(Money.ZERO));
    }

    @DisplayName("로또 한장을 자동으로 구매한다")
    @Test
    void buyLottoSuccess() {
        Money money = Money.won(1000);

        List<Lotto> buyLottos = lottoMachine.buyLotto(money);

        assertThat(buyLottos).hasSize(1);
    }

    @DisplayName("로또 두장을 자동으로 구매한다")
    @Test
    void buyManyLottoSuccess() {
        Money money = Money.won(2000);

        List<Lotto> buyLottos = lottoMachine.buyLotto(money);

        assertThat(buyLottos).hasSize(2);
    }
}