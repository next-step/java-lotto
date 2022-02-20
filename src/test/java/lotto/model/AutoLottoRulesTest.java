package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

class AutoLottoRulesTest {

    @RepeatedTest(100)
    void 여섯개의_숫자를_만든다() {
        AutoLottoRules autoLottoRules = new AutoLottoRules();
        List<LottoNumber> lottoNumbers = autoLottoRules.makeLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.getNumber()).isBetween(1, 45);
        }
    }
}