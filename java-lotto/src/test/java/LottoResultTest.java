import domain.Lotto.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void 수익률_계산_정확성_테스트() {
        Map<Integer, Integer> matchCounts = Map.of(
                3, 1,
                4, 1,
                5, 0,
                6, 0
        );
        LottoResult result = new LottoResult(matchCounts);
        double profitRate = result.calculateProfitRate(3000);
        int expectedPrize = 5000 + 50000;
        assertEquals((double) expectedPrize / 3000, profitRate);
    }
}