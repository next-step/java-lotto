package lottery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lottery.TestLotteryFactory.createLottery;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLotteryTest {

    @Test
    void create_보너스볼_중복() {
        assertThatThrownBy(() -> new WinningLottery(
                createLottery(1, 2, 3, 4, 5, 6).getLotteryNumbers(),
                new LotteryNumber(1)
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("lotteryRankProvider")
    void createLotteryResult(LotteryRank lotteryRank, int expected) {
        WinningLottery winningLottery = new WinningLottery(
                createLottery(1, 2, 3, 4, 5, 6).getLotteryNumbers(),
                new LotteryNumber(45)
        );
        List<Lottery> lotteries = List.of(
                createLottery(1, 2, 3, 14, 15, 16),
                createLottery(1, 2, 3, 14, 15, 16),
                createLottery(1, 2, 3, 4, 15, 16),
                createLottery(1, 2, 3, 4, 5, 16)
        );
        LotteryResult lotteryResult = winningLottery.createLotteryResult(lotteries);

        assertThat(lotteryResult.getWinningCountOfRank(lotteryRank)).isEqualTo(expected);
    }

    static Stream<Arguments> lotteryRankProvider() {
        return Stream.of(
                Arguments.of(LotteryRank.FOURTH, 2),
                Arguments.of(LotteryRank.THIRD, 1),
                Arguments.of(LotteryRank.SECOND, 1)
        );
    }
}
