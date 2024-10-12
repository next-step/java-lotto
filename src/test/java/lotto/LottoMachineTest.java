package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.LottoMachine;

class LottoMachineTest {

    @Test
    void 생성() {

        LottoMachine lottoMachine = new LottoMachine();

        assertThat(lottoMachine).isEqualTo(new LottoMachine());
    }
}
