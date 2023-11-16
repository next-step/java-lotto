package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("입력 개수만큼 로또가 발급된다.")
    void lottos_quantity() {
        LottoMachine lottoMachine = new LottoMachine();

        lottoMachine.issueLottos(5, new AutoLottoNumberGenerator());

        assertThat(lottoMachine.getLottoNumbers()).hasSize(5);
    }
}