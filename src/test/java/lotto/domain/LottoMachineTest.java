package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("10000원 일때 로또 10장이 리턴되는지")
    @Test
    void purchase_lotto_as_money() {
        //given
        int money = 10000;
        LottoMachine lottoMachine = new LottoMachine(new Money(money));
        int expectedSize = 10;

        //when
        Lottos lottos = lottoMachine.pullSlot();

        //then
        assertThat(lottos.size()).isEqualTo(expectedSize);
    }
}
