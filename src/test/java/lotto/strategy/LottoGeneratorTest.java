package lotto.strategy;

import lotto.domain.Lotto;
import lotto.vo.LottoCreateRequest;
import lotto.enumeration.LottoType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Number.numbers;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void 로또_발급() {
        List<Lotto> lottos = List.of(new Lotto(LottoType.AUTO, numbers(1, 2, 3, 4, 5, 6)));
        LottoGenerator lottoGenerator = (count) -> lottos;

        List<Lotto> result = lottoGenerator.generate(new LottoCreateRequest(1000, List.of(new Lotto(LottoType.AUTO, numbers(1, 2, 3, 4, 5, 6)))));
        assertThat(result).hasSize(1);
        assertThat(result).isEqualTo(lottos);
    }
}