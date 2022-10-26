package step2.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MatchIndicatorCalculatorTest {

    @Test
    void 일치_지표를_구할_수_있다() {
        MatchIndicatorCalculator matchIndicatorCalculator = new MatchIndicatorCalculator(List.of(Rank.FOURTH));

        Map<Rank, Long> statisticsRanks = Map.ofEntries(
                Map.entry(Rank.FIRST, 0L),
                Map.entry(Rank.SECOND, 0L),
                Map.entry(Rank.THIRD, 0L),
                Map.entry(Rank.FOURTH, 1L)
        );
        assertThat(matchIndicatorCalculator.matchIndicators()).isEqualTo(statisticsRanks);
    }

}
