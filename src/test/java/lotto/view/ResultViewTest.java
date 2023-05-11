package lotto.view;

import lotto.common.code.MatchedNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ResultViewTest {

    Map<MatchedNumber, Integer> winningStatistics = new HashMap<>();

    @BeforeAll
    void setUp() {
        winningStatistics.put(MatchedNumber.THREE, 1);
        winningStatistics.put(MatchedNumber.FOUR, 1);
        winningStatistics.put(MatchedNumber.FIVE, 0);
        winningStatistics.put(MatchedNumber.FIVE_AND_BONUS, 0);
        winningStatistics.put(MatchedNumber.SIX, 0);
    }

    @Test
    void getTotalWinningAmount() {
        assertThat(ResultView.getTotalWinningAmount(winningStatistics)).isEqualTo(55000);
    }

    @Test
    void getRateOfReturn() {
        assertThat(ResultView.getRateOfReturn(100000, 5000)).isEqualTo(BigDecimal.valueOf(0.05));
    }

    @Test
    void getTotalRorLossText() {
        assertThat(ResultView.getTotalRorLossText(new BigDecimal(0.5))).isEqualTo("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        assertThat(ResultView.getTotalRorLossText(new BigDecimal(1))).isEqualTo("");
    }

}
