package lotto.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {


    @DisplayName("로또는 구매 금액/로또 금액의 몫만큼 구매 가능하다")
    @Test
    void buyLottos(){
        int purchaseAmount = 12500;
        LottoMachine machine = new LottoMachine();

        int lottoCount = machine.buyLottos(purchaseAmount);

        assertThat(lottoCount).isEqualTo(12);
    }
}
