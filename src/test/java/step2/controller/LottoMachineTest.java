package step2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine = new LottoMachine();
    @Test
    @DisplayName("입력받은 구매금액을 통해 몇 개의 로또를 구입할 수 있는지 계산한다.")
    void calculateLottoCount() {
        assertThat(lottoMachine.calculateLottoCount(14000)).isEqualTo(14);
        assertThat(lottoMachine.calculateLottoCount(14500)).isEqualTo(14);
    }
}
