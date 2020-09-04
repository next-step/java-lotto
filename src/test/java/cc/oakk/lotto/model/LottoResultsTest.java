package cc.oakk.lotto.model;

import cc.oakk.lotto.model.prizeprovider.LottoPrizeProvider;
import cc.oakk.lotto.model.prizeprovider.impl.SimpleLottoPrizeProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
    LottoResults results;

    @BeforeEach
    public void beforeEach() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 3, 5, 7, 9, 11), 10);
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2,  3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 3, 5, 7, 9, 11)),
                new Lotto(Arrays.asList(1, 3, 5, 7, 9, 10)),
                new Lotto(Arrays.asList(1, 3, 5, 7, 10, 11)),
                new Lotto(Arrays.asList(1, 4, 8, 12, 16, 20)),
                new Lotto(Arrays.asList(1, 14, 18, 22, 26, 30))));

        results = lottos.getResults(winningLotto);
    }

    @Test
    public void getRankCount() {
        assertThat(results.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(results.getRankCount(Rank.SECOND)).isEqualTo(2);
        assertThat(results.getRankCount(Rank.THIRD)).isEqualTo(0);
        assertThat(results.getRankCount(Rank.FOURTH)).isEqualTo(0);
        assertThat(results.getRankCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(results.getRankCount(Rank.NONE)).isEqualTo(2);
    }

    @Test
    public void calculateRevenue() {
        LottoPrizeProvider<?> provider = new SimpleLottoPrizeProvider();
        assertThat(results.calculateRevenue(provider)).isEqualTo(2060005000L);
    }

    @Test
    public void calculateRevenueRate() {
        LottoPrizeProvider<?> provider = new SimpleLottoPrizeProvider();
        int lottoPrice = 1000;
        double rate = (double) results.calculateRevenue(provider) / (results.size() * lottoPrice);
        assertThat(results.calculateRevenueRate(provider, lottoPrice)).isEqualTo(rate);
    }
}
