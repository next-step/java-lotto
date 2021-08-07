package lotto.util;

import lotto.domain.LottoNumbers;
import lotto.strategy.ListMixStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGeneratorTest {
    @Test
    void generateLotto() {
        LottoNumbers lottoNumbers = LottoNumberGenerator.getLottoNumbers(new ListMixStrategy());
        assertEquals(lottoNumbers.size(), LottoNumberGenerator.SIZE);
        for (Integer number: lottoNumbers.getLottoNumbers()) {
            assertThat(number).isGreaterThanOrEqualTo(LottoNumberGenerator.MIN_NUMBER);
            assertThat(number).isLessThanOrEqualTo(LottoNumberGenerator.MAX_NUMBER);
        }
    }
}
