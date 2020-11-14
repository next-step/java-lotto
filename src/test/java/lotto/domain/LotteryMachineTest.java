package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.Utils.makeRangeNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LotteryMachineTest {
    static Stream<Arguments> checkWinning() {
        return Stream.of(
                arguments(makeRangeNumbers(1, 7), WinningRank.FIRST),
                arguments(makeRangeNumbers(2, 8), WinningRank.SECOND),
                arguments(makeRangeNumbers(3, 9), WinningRank.THIRD),
                arguments(makeRangeNumbers(4, 10), WinningRank.FOURTH),
                arguments(makeRangeNumbers(7, 13), WinningRank.FAIL)
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 번호와 로또 숫자 비교하여 몇 등 인지 확인")
    @MethodSource
    void checkWinning(Numbers numbers, WinningRank expectedWinningRank) {
        LotteryMachine lotteryMachine = new LotteryMachine(makeRangeNumbers(1, 7));

        WinningRank winningRank = lotteryMachine.checkWinningRank(numbers);

        assertThat(winningRank).isEqualTo(expectedWinningRank);
    }
}
