package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName(value = "로또는 한 번에 6개씩 생성된다.")
    @Test
    void generatorLotto() {
        Lotto lottoNumbers = new LottoNumberGenerator().generate();
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }

}
