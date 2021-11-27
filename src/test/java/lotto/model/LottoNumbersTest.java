package lotto.model;

import lotto.factory.LottoNumbersFactory;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 자동생성")
    void autoCreate() {
        LottoNumbers lottoNumbers = LottoNumbersFactory.autoCreateNumbers(new LottoNumberGenerator());
        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
    }

}