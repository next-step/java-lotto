package lotto.domain.lotto;

import lotto.domain.LottoFixtures;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    void 개수만큼_로또를_생성한다() {
        LottoMachine lottoMachine = new LottoMachine(11, LottoFixtures.FIXED_LOTTO_CREATOR);
        assertThat(lottoMachine.getLottos()).hasSize(11);
    }
}
