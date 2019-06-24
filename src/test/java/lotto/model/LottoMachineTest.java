package lotto.model;

import lotto.exception.MinimumAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMachineTest {

    @DisplayName("로또 구매에 실패한다")
    @Test
    void buyLottoWithZeroMoney() {
        Money money = Money.won(0);

        assertThatExceptionOfType(MinimumAmountException.class)
                .isThrownBy(() -> LottoMachine.buy(money));
    }

    @DisplayName("1개의 로또 구매에 성공한다")
    @Test
    void buyLottoWithMoney() {
        Money money = Money.won(1000);

        LottoTicket result = LottoMachine.buy(money);

        assertThat(result.getLottos()).hasSize(1);
    }

    @DisplayName("14개의 로또 구매에 성공한다")
    @Test
    void buyManyLottoWithMoney() {
        Money money = Money.won(14500);

        LottoTicket lottoTicket = LottoMachine.buy(money);

        assertThat(lottoTicket.getLottos()).hasSize(14);
    }
}