package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoMachineTest {

    @Test
    void makeLottos_3000원입력_로또3개() {
        Lottos lottos = LottoAutoMachine.makeLottos(3000);
        assertThat(lottos.getCount()).isEqualTo(3);
    }

}
