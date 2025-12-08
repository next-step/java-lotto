package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @Test
    void 당첨_통계에서_각_등수별_당첨_개수를_셀_수_있다() {
        Lottos lottos = new Lottos(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 8, 9)
        );
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoStatistics statistics = LottoStatistics.calculateStatistics(lottos, winningLotto);

        assertThat(statistics.getCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(statistics.getCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(statistics.getCount(LottoRank.THIRD)).isEqualTo(1);
    }
}
