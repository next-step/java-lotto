package study.step2;

import org.junit.jupiter.api.Test;
import study.step2.domain.LottoNumbers;
import study.step2.domain.LottoNumbersGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    void 로또_번호_생성() {
        LottoNumbersGenerator generator = new LottoNumbersGenerator(new Always1To6Numbers());
        LottoNumbers lottoNumbers = generator.generate();
        assertThat(lottoNumbers.lottoNumbers()).hasSize(6);
        assertThat(lottoNumbers.lottoNumbers()).contains(1);
        assertThat(lottoNumbers.lottoNumbers()).contains(2);
        assertThat(lottoNumbers.lottoNumbers()).contains(3);
        assertThat(lottoNumbers.lottoNumbers()).contains(4);
        assertThat(lottoNumbers.lottoNumbers()).contains(5);
        assertThat(lottoNumbers.lottoNumbers()).contains(6);
    }
}
