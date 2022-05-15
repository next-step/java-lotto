package lotto.domain;

import lotto.factory.WinningNumbersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
    private static final int IS_WIN_LOTTERY = 1;

    @DisplayName("복권 당첨 결과")
    @Test
    void get() {
        // given
        List<Integer> winningNumbers = WinningNumbersFactory.get("1,2,3,4,5,6");
        int bonusNumber = 7;

        LotteryGame lotteryGame = new LotteryGame(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LotteryGame> lotteryGameList = new ArrayList<>();
        lotteryGameList.add(lotteryGame);
        LotteryGames lotteryGames = new LotteryGames(lotteryGameList);

        // when
        Map<Rank, Integer> winningResult = WinningResult.get(winningNumbers, bonusNumber, lotteryGames);

        // then
        assertThat(winningResult.get(Rank.FIRST)).isEqualTo(IS_WIN_LOTTERY);
    }

    @DisplayName("수익")
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

        assertThat(WinningResult.profit(results)).isEqualTo(1510000);
    }

    @DisplayName("수익률")
    @Test
    void profitRate() {
        double profitRate = WinningResult.profitRate(25000, 100000);
        assertThat(profitRate).isEqualTo(0.25);
    }
}
