package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    @DisplayName("로또 숫자가 6개인지 확인")
    void isSixLottoNumbers(){
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = new Lotto(lottoGenerator.randomNumber());
        assertThat(lotto.lotto().size()).isEqualTo(6);
    }

}