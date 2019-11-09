package lotto;

import lotto.domain.Insights;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InsightsTest {
    private Insights insights;

    @BeforeEach
    void setUp() {
        insights = new Insights();
    }

    @Test
    void getInsightsContainsKey() {
        assertThat(insights.updateInsightsLottoRank(Rank.FIRST).get(Rank.FIRST)).isEqualTo(1);
    }
}
