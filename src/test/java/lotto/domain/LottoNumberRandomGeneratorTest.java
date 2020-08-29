package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberRandomGeneratorTest {

    private LottoNumberRandomGenerator lottoNumberRandomGenerator = new LottoNumberRandomGenerator();

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void generator() {
        Set<LottoNumber> lottoNumbers = lottoNumberRandomGenerator.generator(Lotto.LOTTO_SIZE);

        assertThat(lottoNumbers.size()).isEqualTo(Lotto.LOTTO_SIZE);
    }
}
