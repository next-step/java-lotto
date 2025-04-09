import domain.Lotto.LottoResult;
import domain.Lotto.Rank;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void 수익률_계산_정확성_테스트() {
        Map<Rank, Integer> rankCounts = Map.of(
                Rank.FIFTH, 1,
                Rank.FOURTH, 1,
                Rank.THIRD, 0,
                Rank.SECOND, 0,
                Rank.FIRST, 0
        );
        LottoResult result = new LottoResult(rankCounts);
        double profitRate = result.calculateProfitRate(3000);
        int expectedPrize = Rank.FIFTH.getWinningMoney() + Rank.FOURTH.getWinningMoney();
        assertEquals((double) expectedPrize / 3000, profitRate);
    }
}