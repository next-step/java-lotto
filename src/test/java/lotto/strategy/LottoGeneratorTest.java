package lotto.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void 로또_발급() {
        List<Lotto> lottos = List.of(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        LottoGenerator lottoGenerator = (count) -> lottos;

        List<Lotto> result = lottoGenerator.generate(1);
        assertThat(result).hasSize(1);
        assertThat(result).isEqualTo(lottos);
    }
}