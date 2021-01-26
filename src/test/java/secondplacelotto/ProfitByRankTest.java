package secondplacelotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondplacelotto.model.ProfitByRank;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfitByRankTest {

    @Test
    @DisplayName("수익 매칭이 잘 되는가?")
    public void getMatchProfit() {
        assertTrue(ProfitByRank.getMatchProfit("4",2,0) == 100000);
        assertTrue(ProfitByRank.getMatchProfit("1",1,0) == 2000000000);
    }
}
