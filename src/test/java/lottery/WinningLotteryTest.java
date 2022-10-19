package lottery;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static lottery.TestLotteryFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLotteryTest {

    @ParameterizedTest
    @CsvSource(value = {"3:2", "4:1", "5:1"}, delimiter = ':')
    void createLotteryResult(int matchingCount, int expected) {
        WinningLottery winningLottery = new WinningLottery(createLottery(1, 2, 3, 4, 5, 6).getLotteryNumbers());
        List<Lottery> lotteries = List.of(
                createLottery(1, 2, 3, 14, 15, 16),
                createLottery(1, 2, 3, 14, 15, 16),
                createLottery(1, 2, 3, 4, 15, 16),
                createLottery(1, 2, 3, 4, 5, 16)
        );
        LotteryResult lotteryResult = winningLottery.createLotteryResult(lotteries);

        assertThat(lotteryResult.getWinningCountOfRank(matchingCount)).isEqualTo(expected);
    }
}
