package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lottery.domain.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    private Lottery winningLottery;

    static Stream<Arguments> generateTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), LOSING_TICKET),
            Arguments.of(Arrays.asList(1, 8, 9, 10, 11, 12), LOSING_TICKET),
            Arguments.of(Arrays.asList(1, 2, 9, 10, 11, 12), FIFTH),
            Arguments.of(Arrays.asList(1, 2, 3, 10, 11, 12), FOURTH),
            Arguments.of(Arrays.asList(1, 2, 3, 5, 10, 12), THIRD),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 12), SECOND),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), FIRST)
        );
    }

    @BeforeEach
    void init() {
        winningLottery = new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest(name = "번호: {0}, 예상 등수: {1}")
    @DisplayName("당첨 번호와 비교한 뒤, 로또 등수를 반환한다.")
    @MethodSource("generateTestCase")
    void getPrizeAfterComparingLotteries(List<Integer> numbers, Prize expected) {
        Lottery lottery = new Lottery(numbers);

        assertThat(lottery.getPrize(winningLottery)).isEqualTo(expected);
    }

}
