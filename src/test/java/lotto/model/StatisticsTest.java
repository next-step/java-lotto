package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    private Count count;
    private Map<Rank, Integer> totalRanks;
    private Statistics statistics;

    @BeforeEach
    void setUp() {
        count = new Count(5, 1);
        totalRanks = new HashMap<Rank, Integer>() {{
            put(Rank.FIFTH, 1);
            put(Rank.FOURTH, 1);
            put(Rank.THIRD, 0);
            put(Rank.SECOND, 0);
            put(Rank.FIRST, 0);
        }};
        statistics = new Statistics(count, totalRanks);
    }

    @DisplayName("수익률을_계산한다")
    @Test
    void calculateBenefits() {
        double benefits = statistics.calculateBenefits();
        assertThat(benefits).isEqualTo(11.0);
    }
}
