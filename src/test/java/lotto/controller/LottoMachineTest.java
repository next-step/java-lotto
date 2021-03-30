package lotto.controller;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("금액에 맞는 로또 갯수를 반환한다.")
    @Test
    void getLottoCountTest() {
        Money money = new Money("14000");
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.purchaseLotto(money, new ArrayList<>());
        assertThat(lottoMachine.getPurchaseLottoCount().getAutoCount()).isEqualTo(14);
    }
}

