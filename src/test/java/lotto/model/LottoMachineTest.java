package lotto.model;

import lotto.exception.MinimumAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

// 1. n개의 로또를 생성한다.
// 2. 당첨 번호를 생성한다. 당첨번호는 수동
// 3. 당첨 결과 확인
// 2. void - > 당첨 로또번호
public class LottoMachineTest {

    @DisplayName("한개의 로또를 구매한다")
    @Test
    void buyLottoWithMoney() {
        Money money = Money.wons(1000);

        LottoTicket result = LottoMachine.buy(money);

        assertThat(result.getLottos()).hasSize(1);
    }

    @DisplayName("14000원이면 로또를 구매할 수 없다.")
    @Test
    void buyManyLottoWithMoney() {
        Money money = Money.wons(14000);

        LottoTicket lottoTicket = LottoMachine.buy(money);

        assertThat(lottoTicket.getLottos()).hasSize(14);
    }

    @DisplayName("0원이면 로또를 구매할 수 없다.")
    @Test
    void buyLottoWithZeroMoney() {
        Money money = Money.wons(0);

        assertThatExceptionOfType(MinimumAmountException.class)
                .isThrownBy(() -> LottoMachine.buy(money));
    }
}