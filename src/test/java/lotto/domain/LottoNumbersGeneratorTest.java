package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    @DisplayName("로또 넘버 생성이 되는지 테스트한다.")
    void LottoNumbersGeneratorTest() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        LottoGenerator lottoGenerator = () -> new Lotto(lottoNumbers);

        assertThat(lottoGenerator.generateLotto().getLottoNumbers()).isEqualTo(lottoNumbers);
    }
}
