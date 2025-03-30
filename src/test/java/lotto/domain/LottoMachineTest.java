package lotto.domain;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoMachine.PRICE_OF_LOTTO;

public class LottoMachineTest {

    @Test
    public void 로또를_구매금액만큼_구매() {
        LottoMachine machine = new LottoMachine();

        int money = 3000;
        List<LottoNumbers> lottoNumbers = machine.buy(money);
        Assertions.assertThat(lottoNumbers).hasSize(money / PRICE_OF_LOTTO);
    }

    @Test
    public void 로또구매시_1000원_미만은_에러() {
        LottoMachine machine = new LottoMachine();

        int money = 500;
        assertThatThrownBy(() -> machine.buy(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
