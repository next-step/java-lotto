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

class LotteryTest {

    static Stream<Arguments> generateTestCase() {
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

    static Stream<Arguments> generateInvalidWinningLottery() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 8),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 50),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 50), 7)
        );
    }

    @Test
    @DisplayName("생성할 수 없는 번호가 포함되어 있으면 예외를 던진다.")
    void throwExceptionIfInvalidNumberContained() {
        List<Integer> numbers = Arrays.asList(1, 7, 10, 23, 36, 47);

        assertThatThrownBy(() -> new Lottery(numbers)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("로또 번호 가운데 중복된 것이 있으면 예외를 던진다.")
    void throwExceptionIfNumbersDuplicated() {
        List<Integer> numbers = Arrays.asList(1, 7, 10, 23, 36, 36);

        assertThatThrownBy(() -> new Lottery(numbers)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외를 던진다.")
    void throwExceptionIfLotteryNumberIsInsufficient() {
        List<Integer> numbers = Arrays.asList(1, 7, 10, 23, 36);

        assertThatThrownBy(() -> new Lottery(numbers)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "번호: {0}, 예상 등수: {1}")
    @DisplayName("당첨 번호와 비교한 뒤, 로또 등수를 반환한다.")
    @MethodSource("generateTestCase")
    void getPrizeAfterComparingLotteries(List<Integer> numbers, Prize expected) {
        Lottery lottery = new Lottery(numbers);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int winningBonusNumber = 7;

        assertThat(lottery.getPrize(winningNumbers, winningBonusNumber)).isEqualTo(expected);
    }

    @DisplayName("유효하지 않은 당첨 번호로 등수를 알아내려고 시도하면 예외 처리한다.")
    @ParameterizedTest(name = "당첨 번호 - {0}, 보너스 번호 - {1}")
    @MethodSource("generateInvalidWinningLottery")
    void throwExceptionIfInvalidWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        Lottery lottery = new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lottery.getPrize(winningNumbers, bonusNumber)).isInstanceOf(RuntimeException.class);
    }
}
