package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningResultTest {
    private WinningResult winningResult;

    @BeforeEach
    void setup() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        int bonusNumber = 7;

        LotteryGame lotteryGame = new LotteryGame(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LotteryGame> lotteryGameList = new ArrayList<>();
        lotteryGameList.add(lotteryGame);
        LotteryGames lotteryGames = new LotteryGames(lotteryGameList);

        winningResult = new WinningResult(winningNumbers, bonusNumber, lotteryGames);
    }

    @DisplayName("복권 당첨 결과")
    @Test
    void get() {
        Map<Rank, Integer> rankMap = winningResult.get();

        assertAll(
                () -> assertThat(rankMap.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(rankMap.get(Rank.SECOND)).isEqualTo(0),
                () -> assertThat(rankMap.get(Rank.THIRD)).isEqualTo(0),
                () -> assertThat(rankMap.get(Rank.FOURTH)).isEqualTo(0),
                () -> assertThat(rankMap.get(Rank.FIFTH)).isEqualTo(0),
                () -> assertThat(rankMap.get(Rank.MISS)).isEqualTo(0)
        );
    }

    @DisplayName("수익 확")
    @Test
    void profit() {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class) {
            {
                put(Rank.FIFTH, 2);
                put(Rank.FOURTH, 0);
                put(Rank.THIRD, 1);
                put(Rank.FIRST, 0);
            }
        };

        assertThat(winningResult.profit(results)).isEqualTo(1510000);
    }

    @DisplayName("수익률인 확인")
    @Test
    void profitRate() {
        double profitRate = winningResult.profitRate(25000, 100000);
        assertThat(profitRate).isEqualTo(0.25);
    }
}
