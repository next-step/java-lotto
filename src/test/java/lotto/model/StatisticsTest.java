package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    private Statistics statistics;
    private Ranks ranks;
    private List<MatchInfo> matchInfos;

    @BeforeEach
    void setUp() {
        ranks = new Ranks();
        matchInfos = Arrays.asList(
            new MatchInfo(0, false),
            new MatchInfo(1, false),
            new MatchInfo(0, false),
            new MatchInfo(3, false),
            new MatchInfo(4, false)
        );
        ranks.updateRanks(matchInfos);
        statistics = new Statistics(ranks);
    }

    @DisplayName("수익률을_계산한다")
    @Test
    void calculateBenefits() {
        double benefits = statistics.calculateBenefits();
        assertThat(benefits).isEqualTo(11.0);
    }
}
