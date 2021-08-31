package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    @DisplayName("로또 넘버 생성이 되는지 테스트한다.")
    void LottoNumbersGeneratorTest() {

        Set<LottoNumber> lottoNumbers = new TreeSet<>(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );

        LottoGenerator lottoGenerator = () -> new Lotto(lottoNumbers);

        assertThat(lottoGenerator.generateLotto().getLottoNumbers()).isEqualTo(lottoNumbers);
    }
}
