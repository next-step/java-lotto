package step2.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.Lotto;
import step2.lotto.domain.Lottos;
import step2.lotto.domain.Statistic;

public class StatisticTest {

    @Test
    void 통계_테스트() {
        Lotto lastWeekLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        Lottos lottos = new Lottos(List.of(
            new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),    // 3개 일치 → 5000
            new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),    // 4개 일치 → 50000
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)),    // 5개 일치 → 1500000
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),    // 6개 일치 → 2000000000
            new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)) // 0개 일치 → 당첨금 없음
        ));

        Statistic statistic = new Statistic();

        // when (실행)
        statistic.calculate(lottos, lastWeekLotto);

        // then (검증)
        // 통계 Map 확인
        assertThat(statistic.getMatchCountMap().getOrDefault(3, 0)).isEqualTo(1);
        assertThat(statistic.getMatchCountMap().getOrDefault(4, 0)).isEqualTo(1);
        assertThat(statistic.getMatchCountMap().getOrDefault(5, 0)).isEqualTo(1);
        assertThat(statistic.getMatchCountMap().getOrDefault(6, 0)).isEqualTo(1);

        // 총 당첨금 검증
        long expectedTotal = 5000 + 50000 + 1500000 + 2000000000L; // 3+4+5+6 일치의 합
        assertThat(statistic.getTotalPrize()).isEqualTo(expectedTotal);
    }

}
