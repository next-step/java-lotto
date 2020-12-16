package step2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.controller.LottoMachine;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("입력받은 구매금액을 통해 몇 개의 로또를 구입할 수 있는지 계산한다.")
    void calculateLottoCount() {
        assertThat(LottoMachine.calculateLottoCount(14000)).isEqualTo(14);
        assertThat(LottoMachine.calculateLottoCount(14500)).isEqualTo(14);
    }
}
