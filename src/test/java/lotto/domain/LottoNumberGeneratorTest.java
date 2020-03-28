package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @DisplayName("무작위 6개의 로또 번호를 생성한다.")
    @Test
    void generate() {
        LottoNumbers lottoNumbers = LottoNumberGenerator.generate();

        assertThat(lottoNumbers).isNotNull();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}