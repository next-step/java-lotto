package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 숫자가 6개인지 확인")
    void isSixLottoNumbers(){
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoNumbers lottoNumbers = new LottoNumbers(lottoGenerator.randomNumber());
        assertThat(lottoNumbers.lottoNumbers().size()).isEqualTo(6);
    }

}