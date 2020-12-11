package autolotto;

import autolotto.model.ProfitMatcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class ProfitMatcherTest {

    @Test
    @DisplayName("당첨번호 갯수별 수익 계산을 제대로 하는가")
    public void matchProfit(){
        assertTrue(ProfitMatcher.getMatchProfit(3,2) == 10000);
        assertTrue(ProfitMatcher.getMatchProfit(4,2) == 100000);
        assertTrue(ProfitMatcher.getMatchProfit(5,2) == 3000000);
        assertTrue(ProfitMatcher.getMatchProfit(6,1) == 2000000000);
    }
}
