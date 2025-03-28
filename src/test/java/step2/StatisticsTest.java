package step2;

import org.junit.jupiter.api.Test;
import step2.domain.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step2.util.LottoNumberUtils.of;

public class StatisticsTest {
    @Test
    void test() {
        List<Lotto> lottoList = List.of(
                new Lotto(of(1, 2, 3, 4, 5, 6)), // 6개 동일
                new Lotto(of(2, 3, 4, 5, 6, 19)), // 5개 동일 + 보너스
                new Lotto(of(2, 3, 4, 5, 6, 7)), // 5개 동일
                new Lotto(of(13, 14, 15, 16, 17, 18)) // 0개 동일
        );
        Lottos lottos = new Lottos(lottoList);
        Winning winning = new Winning(of(1, 2, 3, 4, 5, 6), new LottoNum(19));

        Statistics statistics = Statistics.from(lottos, winning);
        Map<Rank, Integer> winningCounts = statistics.winningCounts();

        assertThat(winningCounts.get(Rank.FIRST)).isEqualTo(1);
        assertThat(winningCounts.get(Rank.SECOND)).isEqualTo(1);
        assertThat(winningCounts.get(Rank.THIRD)).isEqualTo(1);
        assertThat(winningCounts.getOrDefault(Rank.NONE, 0)).isEqualTo(0);
    }

    @Test
    void profitRate() {
        List<Lotto> lottoList = List.of(
                new Lotto(of(1, 2, 3, 4, 5, 6)),       // 6개 일치 → 2,000,000,000
                new Lotto(of(2, 3, 4, 5, 6, 19)),       // 5개 일치 + 보너스 → 30,000,000
                new Lotto(of(2, 3, 4, 5, 6, 7)),       // 5개 일치 → 1,500,000
                new Lotto(of(13, 14, 15, 16, 17, 18))  // 0개 일치 → 0
        );

        Lottos lottos = new Lottos(lottoList);
        Winning winning = new Winning(of(1, 2, 3, 4, 5, 6), new LottoNum(19));
        Statistics statistics = Statistics.from(lottos, winning);
        double profitRate = statistics.profitRate(4000); // 4장

        double expected = (2_000_000_000 +  30_000_000 + 1_500_000) / 4000.0;
        assertThat(profitRate).isEqualTo(expected);
    }
}
