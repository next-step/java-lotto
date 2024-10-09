package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 생성() {

        LottoMachine lottoMachine = new LottoMachine(new LottoNumbers(1, 45));

        assertThat(lottoMachine).isEqualTo(new LottoMachine(new LottoNumbers(1, 45)));
    }

    @Test
    void 로또를_생성한다() {
        LottoMachine lottoMachine = new LottoMachine(new LottoNumbers(1, 45));

        Lotto lotto = lottoMachine.generateLotto();

        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }
}
