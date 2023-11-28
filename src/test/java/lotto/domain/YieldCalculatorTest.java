package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class YieldCalculatorTest {

    @Test
    @DisplayName("구매한 총 비용과 로또의 등수로 수익률을 계산한다.")
    void calculate_yield() {
        // given
        long cost = 14000;
        RankResult rankResult = createRankResult();

        // when
        double result = YieldCalculator.calculate(cost, rankResult);

        // then
        assertThat(result).isEqualTo(0.35);
    }

    private RankResult createRankResult() {
        Map<Rank, Long> rankResult = new HashMap<>();
        rankResult.put(Rank.NOTHING, 0L);
        rankResult.put(Rank.FIFTH, 1L);
        rankResult.put(Rank.FOURTH, 0L);
        rankResult.put(Rank.THIRD, 0L);
        rankResult.put(Rank.SECOND, 0L);
        rankResult.put(Rank.FIRST, 0L);
        return new RankResult(rankResult);
    }
}
