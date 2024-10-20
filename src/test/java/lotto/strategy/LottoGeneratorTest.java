package lotto.strategy;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Number.numbers;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void 로또_발급() {
        List<Lotto> lottos = List.of(new Lotto(numbers(1, 2, 3, 4, 5, 6)));
        LottoGenerator lottoGenerator = (count) -> lottos;

        List<Lotto> result = lottoGenerator.generate(1);
        assertThat(result).hasSize(1);
        assertThat(result).isEqualTo(lottos);
    }
}