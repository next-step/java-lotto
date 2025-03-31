package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultsTest {
    @Test
    @DisplayName("1등 당첨 금액을 확인한다.")
    void FirstCalculatePrizeTest() {
        Map<Winning, Integer> matchResult = new HashMap<>();
        matchResult.put(Winning.FIRST, 1);
        WinningResults winningResults = new WinningResults(matchResult);
        assertThat(winningResults.calculatePrize()).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("3등 당첨 금액을 확인한다.")
    void ThirdCalculatePrizeTest() {
        Map<Winning, Integer> matchResult = new HashMap<>();
        matchResult.put(Winning.THIRD, 1);
        WinningResults winningResults = new WinningResults(matchResult);
        assertThat(winningResults.calculatePrize()).isEqualTo(1500000);
    }

    @Test
    @DisplayName("4등 당첨 금액을 확인한다.")
    void FourthCalculatePrizeTest() {
        Map<Winning, Integer> matchResult = new HashMap<>();
        matchResult.put(Winning.FOURTH, 1);
        WinningResults winningResults = new WinningResults(matchResult);
        assertThat(winningResults.calculatePrize()).isEqualTo(50000);
    }

    @Test
    @DisplayName("5등 당첨 금액을 확인한다.")
    void FifthCalculatePrizeTest() {
        Map<Winning, Integer> matchResult = new HashMap<>();
        matchResult.put(Winning.FIFTH, 1);
        WinningResults winningResults = new WinningResults(matchResult);
        assertThat(winningResults.calculatePrize()).isEqualTo(5000);
    }
}
