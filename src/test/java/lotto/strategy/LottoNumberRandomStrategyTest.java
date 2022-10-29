package lotto.strategy;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberRandomStrategyTest {

    @Test
    void generate() {
        LottoNumbersStrategy strategy = new LottoNumbersRandomStrategy();
        LottoNumbers lottoNumbers = strategy.generate();

        assertThat(lottoNumbers.getLottoNumbers()
                               .stream()
                               .distinct()
                               .count()).isEqualTo(6);
        assertThat(lottoNumbers.getLottoNumbers()).allMatch(lottoNumber ->
                lottoNumber.compareTo(new LottoNumber(1)) >= 0 && lottoNumber.compareTo(new LottoNumber(45)) <= 0);
    }
}
