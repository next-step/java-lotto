package lotto.entity;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 금액_입력_시_반환_되는_로또_리스트() {
        List<Lotto> lottos = LottoMachine.insert(14000);

        assertThat(lottos).hasSize(14);
    }

    @Test
    void 로또_한장의_번호_갯수_검증() {
        List<Lotto> lottos = LottoMachine.insert(1000);
        Lotto lotto = lottos.get(0);
        assertThat(lotto.getNumbers()).hasSize(6);
    }
}
