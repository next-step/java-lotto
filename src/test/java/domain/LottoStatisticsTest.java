package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    private final LottoGenerator lottoGenerator = LottoGenerator.getInstance();

    @Test
    void 당첨로또와_구매로또의_통계를_알_수_있다() {
        Price purchasePrice = new Price(2000);
        List<Lotto> lottos = List.of(lottoGenerator.generateLotto(List.of(1, 2, 3, 40, 41, 42)),
                lottoGenerator.generateLotto(List.of(1, 2, 3, 41, 42, 43)));

        WinningLotto winningLotto = lottoGenerator.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoStatistics statistics = new LottoStatistics(lottos, winningLotto);

        assertThat(statistics.findWinningPrice()).isEqualTo(new Price(5000 + 5000)); // 당첨금액
        assertThat(statistics.calculateEfficiency(purchasePrice)).isEqualTo(5); //효율
    }
}
