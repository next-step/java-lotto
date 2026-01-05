package lotto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    
    @Test
    void 수동_로또와_자동_로또를_합쳐서_총_구매_개수가_맞는지_확인한다() {
        List<Lotto> lotto = List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(13, 14, 15, 16, 17, 18)
        );

        Lottos lottos = LottoGenerator.generate(BigDecimal.valueOf(14000), new Lottos(lotto));

        assertThat(lottos.size()).isEqualTo(14);
    }
}
