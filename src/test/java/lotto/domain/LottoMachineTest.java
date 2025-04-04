package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoMachine.PRICE_OF_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    @Test
    public void 로또를_구매금액만큼_구매() {
        LottoMachine machine = new LottoMachine();

        int money = 3000;
        Lottos lottos = machine.buy(money);
        Assertions.assertThat(lottos.size()).isEqualTo(money / PRICE_OF_LOTTO);
    }

    @Test
    public void 로또구매시_1000원_미만은_에러() {
        LottoMachine machine = new LottoMachine();

        int money = 500;
        assertThatThrownBy(() -> machine.buy(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또구매시_수동구매번호도_추가() {
        LottoMachine machine = new LottoMachine();
        List<String> manualLottoNumberInputs = new ArrayList<>();
        String userInput1 = "1,2,3,4,5,6";
        String userInput2 = "7,8,9,10,11,12";
        manualLottoNumberInputs.add(userInput1);
        manualLottoNumberInputs.add(userInput2);

        int money = 3000;
        Lottos lottos = machine.buy(money, manualLottoNumberInputs);

        assertThat(lottos.size()).isEqualTo(money / PRICE_OF_LOTTO);
        assertThat(lottos.get(0)).isEqualTo(LottoNumbers.toLottoNumber(userInput1));
        assertThat(lottos.get(1)).isEqualTo(LottoNumbers.toLottoNumber(userInput2));
    }
}
