package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultsTest {
    @Test
    @DisplayName("당첨 금액을 확인한다.")
    void calculatePrizeTest() {
        Map<Winning, Integer> matchResult = new HashMap<>();
        matchResult.put(Winning.FIRST, 1);
        WinningResults winningResults = new WinningResults(matchResult);
        assertThat(winningResults.calculatePrize()).isEqualTo(2000000000);
    }
}
