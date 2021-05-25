package lotto.model;

import lotto.util.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    void makeLottoNumbersTest() {
        Set<LottoNumber> lottoNumbers = LottoNumberGenerator.makeLottoNumber();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
