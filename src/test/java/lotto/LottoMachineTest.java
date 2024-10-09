package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 생성() {

        LottoMachine lottoMachine = new LottoMachine(new LottoNumbers(1, 45));

        assertThat(lottoMachine).isEqualTo(new LottoMachine(new LottoNumbers(1, 45)));
    }

    @Test
    void 로또를_생성한다() {
        LottoMachine lottoMachine = new LottoMachine(new LottoNumbers(1, 45), new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Lotto lotto = lottoMachine.generateLotto();

        assertThat(lotto.getLottoNumbers()).hasSize(6);
        assertThat(lotto.getLottoNumbers().containsAll(List.of(1, 2, 3, 4, 5, 6)));
    }
}
