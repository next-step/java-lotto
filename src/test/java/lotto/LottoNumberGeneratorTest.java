package lotto;

import lotto.domain.RandomLottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class LottoNumberGeneratorTest {
    @Test
    void 고정_로또번호_6개_뽑기() {
        // given
        FixedLottoNumberGenerator lottoNumberGenerator = new FixedLottoNumberGenerator();

        // when
        Set<Integer> generatedNumbers = lottoNumberGenerator.generateNumbers();

        // then
        Assertions.assertThat(generatedNumbers).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또번호_6개_뽑기() {
        // given
        RandomLottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();

        // when
        Set<Integer> generatedNumbers = lottoNumberGenerator.generateNumbers();

        // then
        Assertions.assertThat(generatedNumbers.size()).isEqualTo(6);
    }
}
