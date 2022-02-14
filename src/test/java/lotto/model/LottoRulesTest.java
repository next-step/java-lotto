package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoRulesTest {

   // @RepeatedTest(100)
    @Test
    void 여섯개의_숫자를_만든다() {
        LottoRules lottoRules = new LottoRules();
        List<LottoNumber> lottoNumbers = lottoRules.makeLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.getNumber()).isBetween(1, 45);
        }
        for(LottoNumber lottonumber: lottoNumbers){
            System.out.println(lottonumber.getNumber());
        }

    }
}