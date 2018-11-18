package lotto.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticsTest {
    private Statistics statistics;

    @Before
    public void setup() {
        List<Lotto> lottos = Arrays.asList(
                Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Lotto.from(Arrays.asList(34, 35, 5, 38, 13, 30)),
                Lotto.from(Arrays.asList(3, 36, 37, 41, 27, 13))
        );
        WinningLotto winningLotto = WinningLotto.from(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        statistics = new Statistics(lottos, winningLotto);
    }

    @Test
    public void 당첨자는_일등만_한명() {
        Map<Rank, Integer> countOfRank = statistics.getCountOfRank();
        assertThat(countOfRank.get(Rank.FIRST)).isEqualTo(1);
        assertThat(countOfRank.get(Rank.SECOND)).isEqualTo(0);
        assertThat(countOfRank.get(Rank.THIRD)).isEqualTo(0);
        assertThat(countOfRank.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(countOfRank.get(Rank.FIFTH)).isEqualTo(0);
        assertThat(countOfRank.get(Rank.MISS)).isEqualTo(2);
    }

    @Test
    public void 수익률() {
        assertThat(statistics.getReturnsOfInvestment()).isEqualTo(666666.67);
    }
}