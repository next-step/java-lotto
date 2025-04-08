package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {
    @DisplayName("갯수를 가져온다.")
    @Test
    void getCountTest() {
        MatchResult matchResult = new MatchResult();
        matchResult.addRank(Rank.FIRST);

        assertThat(matchResult.getCount(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitTest() {
        MatchResult matchResult = new MatchResult();
        matchResult.addRank(Rank.FIFTH);

        int purchaseAmount = 1000;
        double profit = matchResult.calculateProfit(purchaseAmount);

        assertThat(profit).isEqualTo(5.0);
    }
}
