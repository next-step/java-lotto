import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.Map;

public class LottoGameTest {

    @DisplayName("로또게임_플레이_전체_흐름_테스트")
    @Test
    void should_calculate_total_profit_rate_correctly() {
        Map<Rank, Integer> stats = new EnumMap<>(Rank.class);
        stats.put(Rank.FIFTH, 1); // 3개 일치 → 5등 1건

        int totalPrize = Rank.FIFTH.getWinningMoney(); // 5,000원

        ResultStats resultStats = new ResultStats(stats, totalPrize);

        int totalSpent = Lotto.PRICE;
        double profitRate = resultStats.calculateProfitRate(totalSpent);

        assertEquals(5.0, profitRate, 0.01); // 5,000 / 1,000 = 5.0
    }
}
