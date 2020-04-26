package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void generateAuto() {
        Lottos lottos = LottoMachine.generate(5);
        assertThat(lottos.size()).isEqualTo(5);
    }

}
