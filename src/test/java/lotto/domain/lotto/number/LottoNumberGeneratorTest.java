package lotto.domain.lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberGeneratorTest {
    @DisplayName("LottoNumber 6개를 만든다")
    @Test
    public void should_make_object_with_count_6_lotto_number() throws Exception {
        //arrange, act
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate();

        //assert
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}