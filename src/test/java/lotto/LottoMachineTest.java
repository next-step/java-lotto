package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("6개의 랜덤한 로또 번호를 생성한다")
    void shouldGenerateLottoNumber() {
        LottoNumbers lottoNumbers = LottoMachine.generateLottoNumber();
        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
    }
}