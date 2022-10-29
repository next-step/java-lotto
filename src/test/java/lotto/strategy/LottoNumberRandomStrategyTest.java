package lotto.strategy;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberRandomStrategyTest {

    @Test
    void generate() {
        LottoNumbersStrategy strategy = new LottoNumbersRandomStrategy();
        List<LottoNumber> lottoNumbers = strategy.generate();

        assertThat(lottoNumbers.stream()
                               .distinct()
                               .count()).isEqualTo(6);
        assertThat(lottoNumbers).allMatch(lottoNumber ->
                lottoNumber.compareTo(new LottoNumber(1)) >= 0 && lottoNumber.compareTo(new LottoNumber(45)) <= 0);
    }
}
