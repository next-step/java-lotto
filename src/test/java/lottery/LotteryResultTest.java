package lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {

    LotteryResult lotteryResult;

    @BeforeEach
    void setUp() {
        EnumMap<LotteryRank, Integer> winningCounts = new EnumMap<>(Map.of(
                LotteryRank.THREE, 2,
                LotteryRank.SIX, 1
        ));
        lotteryResult = new LotteryResult(winningCounts, 10, 1000);
    }


    @Test
    void getWinningCountOfRank() {
        assertThat(lotteryResult.getWinningCountOfRank(3)).isEqualTo(2);
        assertThat(lotteryResult.getWinningCountOfRank(6)).isEqualTo(1);
    }

    @Test
    void getReturnRate() {
        assertThat(lotteryResult.getReturnRate()).isEqualTo(200001);
    }

}
