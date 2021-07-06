package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultsTest {
    WinningResults winningResults;
    @BeforeEach
    void setUp() {
        Map<WinningResult, Integer> wr = new HashMap<>();
        int count = 5;
        for (WinningResult value : WinningResult.values()) {
            wr.put(value, count);
            count --;
        }
        winningResults = new WinningResults(wr);
    }

    @DisplayName(value = "수익률 계산하기")
    @Test
    void calculate_earning_rate() {
        assertThat(winningResults.calculateEarningRate(10000)).isEqualTo(3317);
    }
}
