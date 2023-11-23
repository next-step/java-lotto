package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class YieldCalculatorTest {

    @Test
    @DisplayName("구매한 총 비용과 로또의 등수로 수익률을 계산한다.")
    void calculate_yield() {
        // given
        long cost = 14000;
        List<RankResult> rankResults = createRanks();

        // when
        double result = YieldCalculator.calculate(cost, rankResults);

        // then
        assertThat(result).isEqualTo(0.35);
    }

    private List<RankResult> createRanks() {
        List<RankResult> rankResults = new ArrayList<>();
        rankResults.add(new RankResult(Rank.NOTHING, 0L));
        rankResults.add(new RankResult(Rank.FOURTH, 1L));
        rankResults.add(new RankResult(Rank.THIRD, 0L));
        rankResults.add(new RankResult(Rank.SECOND, 0L));
        rankResults.add(new RankResult(Rank.FIRST, 0L));
        return rankResults;
    }
}
