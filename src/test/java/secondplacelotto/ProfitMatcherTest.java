package secondplacelotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondplacelotto.model.ProfitMatcher;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfitMatcherTest {

    @Test
    @DisplayName("수익 매칭이 잘 되는가?")
    public void getMatchProfit() {
        assertTrue(ProfitMatcher.getMatchProfit(0,6) == 30000);
        assertTrue(ProfitMatcher.getMatchProfit(4,1) == 2000000000);
    }
}
