package lotto.domain;

import lotto.interfaces.LotteryGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WinningResultsTest {
    private WinningResults winningResults;
    private int purchasePrice;
    private Map<Rank, Integer> results;

    @BeforeAll
    void setUp() {
        List<LotteryGame> lotteryGameList = new ArrayList<>();
        lotteryGameList.add(new ManualLotteryGame("1,2,3,4,5,6"));
        lotteryGameList.add(new ManualLotteryGame("1,2,3,4,5,7"));

        purchasePrice = 2000;
        LotteryGames lotteryGames = new LotteryGames(purchasePrice, lotteryGameList);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");

        winningResults = new WinningResults(lotteryGames, winningNumbers);
        results = winningResults.result();
    }

    @DisplayName("로또 게임 결과 확인")
    @Test
    void result() {
        assertAll(
                () -> assertThat(results.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(results.get(Rank.SECOND)).isEqualTo(1),
                () -> assertThat(results.get(Rank.THIRD)).isEqualTo(0),
                () -> assertThat(results.get(Rank.FOURTH)).isEqualTo(0),
                () -> assertThat(results.get(Rank.FIFTH)).isEqualTo(0),
                () -> assertThat(results.get(Rank.MISS)).isEqualTo(0)
        );
    }

    @DisplayName("수익률 확인")
    @Test
    void profit() {
        assertThat(winningResults.profit(results, purchasePrice)).isEqualTo((float) 2030000000 / purchasePrice);
    }
}
