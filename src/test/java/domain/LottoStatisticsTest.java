package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    private final LottoGenerator lottoGenerator = LottoGenerator.getInstance();

    @Test
    void 당첨로또와_구매로또의_통계를_알_수_있다() {
        Price purchasePrice = new Price(2000);
        List<Lotto> lottos = List.of(lottoGenerator.generate(List.of(1, 2, 3, 40, 41, 42)),
                lottoGenerator.generate(List.of(1, 2, 3, 41, 42, 43)));

        Lotto winningLotto = lottoGenerator.generate(List.of(1, 2, 3, 4, 5, 6));

        LottoStatistics statistics = new LottoStatistics(purchasePrice);
        statistics.analysis(lottos, winningLotto);

        assertThat(statistics.getWinningPrice()).isEqualTo(new Price(5000 + 5000)); // 당첨금액
        assertThat(statistics.calculateEfficiency()).isEqualTo(5); //효율
    }
}
