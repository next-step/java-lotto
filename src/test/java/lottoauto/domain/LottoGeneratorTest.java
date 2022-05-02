package lottoauto.domain;

import lottoauto.domain.LottoGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    void lotto_valid_test(){
        assertThat(LottoGenerator.makeLotto().getClass().getName()).isEqualTo(Lotto.class.getName());
    }

}