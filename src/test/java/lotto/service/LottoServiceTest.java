package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Price;
import lotto.model.Statistics;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @Test
    void 로또_발행() {
        Price price = new Price(2000);
        LottoService lottoService = new LottoService(() -> List.of(1, 2, 3, 4, 5, 6));

        Lottos lottos = lottoService.generateLottos(price);

        assertThat(lottos).isEqualTo(new Lottos(List.of(new Lotto(1,2,3,4,5,6), new Lotto(1,2,3,4,5,6))));
    }

    @Test
    void 통계() {
        LottoService lottoService = new LottoService(() -> List.of());
        Price price = new Price(2000);
        Lottos lottos = new Lottos(List.of(new Lotto(1, 2, 3, 7, 8, 9), new Lotto(1, 2, 3, 4, 7, 8)));
        Lotto winningLottos = new Lotto(1, 2, 3, 4, 5, 6);

        Statistics statistics = lottoService.generateStatistics(lottos, winningLottos, price);

        assertThat(statistics).isEqualTo(new Statistics(List.of(1L, 1L, 0L, 0L), 27.5));
    }
}