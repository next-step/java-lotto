import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultStatsTest {

    @DisplayName("수익률 계산이 정확하게 수행된다")
    @Test
    void should_calculate_profit_rate_correctly() {
        Map<Rank, Integer> stats = Map.of(Rank.FIFTH, 1);
        ResultStats rs = new ResultStats(stats, Rank.FIFTH.getWinningMoney());

        assertEquals(5.0, rs.calculateProfitRate(1000), 0.01);
    }
}
