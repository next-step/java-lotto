package lotto.entity;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    void 금액_입력_시_반환_되는_로또_리스트() {
        LottoMachine machine = new LottoMachine();

        List<Lotto> lottos = machine.insert(14000);

        assertThat(lottos).hasSize(14);

    }
}
