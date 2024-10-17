package lotto.strategy;

import lotto.domain.Lotto;
import lotto.domain.Number;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void 로또_발급() {
        List<Lotto> lottos = List.of(new Lotto(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6))));
        LottoGenerator lottoGenerator = (count) -> lottos;

        List<Lotto> result = lottoGenerator.generate(1);
        assertThat(result).hasSize(1);
        assertThat(result).isEqualTo(lottos);
    }
}