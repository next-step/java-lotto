package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lottery.domain.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLotteryTest {

    static Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), LOSING_TICKET),
            Arguments.of(Arrays.asList(1, 8, 9, 10, 11, 12), LOSING_TICKET),
            Arguments.of(Arrays.asList(1, 2, 9, 10, 11, 12), LOSING_TICKET),
            Arguments.of(Arrays.asList(1, 2, 3, 10, 11, 12), FIFTH),
            Arguments.of(Arrays.asList(1, 2, 3, 5, 10, 12), FOURTH),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 12), THIRD),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), SECOND),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), FIRST)
        );
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되었다면 예외를 던진다.")
    void throwExceptionIfNumbersDuplicated() {
        List<Integer> numbers = Arrays.asList(1, 7, 10, 23, 36, 41);

        LotteryNumbers winningNumbers = new LotteryNumbers(numbers);
        LotteryNumber bonusNumber = new LotteryNumber(23);

        assertThatThrownBy(() -> new WinningLottery(winningNumbers, bonusNumber)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "번호: {0}, 예상 등수: {1}")
    @DisplayName("당첨 번호와 비교한 뒤, 로또 등수를 반환한다.")
    @MethodSource("generateTestData")
    void getPrizeAfterComparingLotteries(List<Integer> numberList, Prize expected) {
        LotteryNumbers lotteryNumbers = new LotteryNumbers(numberList);

        List<Integer> winningNumberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        LotteryNumbers winningNumbers = new LotteryNumbers(winningNumberList);
        LotteryNumber bonusNumber = new LotteryNumber(7);
        WinningLottery winningLottery = new WinningLottery(winningNumbers, bonusNumber);

        assertThat(winningLottery.getPrize(lotteryNumbers)).isEqualTo(expected);
    }

}
