package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("복권 당첨 결과")
    @Test
    void get() {
        List<Integer> winningNumbers = WinningNumbers.get("1,2,3,4,5,6");
        LotteryGames lotteryGames = new LotteryGames();
        LotteryGames lotteryGames1 = lotteryGames.create(5);
        Map<Integer, Integer> winningResult = WinningResult.get(winningNumbers, lotteryGames1);
        assertThat(winningResult).isNotEmpty();
    }

    @DisplayName("수익")
    @Test
    void profit() {
        Map<Integer, Integer> results = new LinkedHashMap<>() {
            {
                put(3, 2);
                put(4, 0);
                put(5, 1);
                put(6, 0);
            }
        };

        int profit = WinningResult.profit(results);
        assertThat(profit).isEqualTo(1510000);
    }

    @DisplayName("수익률")
    @Test
    void profitRate() {
        double profitRate = WinningResult.profitRate(25000, 100000);
        assertThat(profitRate).isEqualTo(0.25);
    }
}
