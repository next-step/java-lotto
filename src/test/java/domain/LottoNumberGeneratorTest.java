package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    public void 로또_번호를_반환한다() {
        LottoNumbers lottoNumbers = LottoNumberGenerator.generateNumbers();

        assertThat(lottoNumbers.getNumbers()).hasSize(6);
    }
}