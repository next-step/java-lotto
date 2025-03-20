package lotto.model.generator;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.LottoWallet;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 로또_번호_생성() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoWallet lottoWallet = lottoMachine.getLottoNumbers(5);
        assertThat(lottoWallet.getLottoCount()).isEqualTo(5);
        assertThat(lottoWallet.getLotto(0).getLottoNumbers()).hasSize(6);
    }

}
