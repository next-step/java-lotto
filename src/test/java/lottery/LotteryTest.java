package lottery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {

    @Test
    void generate() {
        Lottery lottery = new Lottery();
        List<Integer> lotteryNumbers = lottery.getLotteryNumbers();

        assertThat(lotteryNumbers).hasSize(6);
        assertThat(lotteryNumbers.stream().min(Integer::compareTo).get()).isGreaterThanOrEqualTo(1);
        assertThat(lotteryNumbers.stream().max(Integer::compareTo).get()).isLessThanOrEqualTo(45);
        assertThat(lotteryNumbers).doesNotHaveDuplicates();
    }

    @ParameterizedTest(name = "countEqualNumbers() - {2}")
    @MethodSource("lotteryNumbersProvider")
    void countEqualNumbers(List<Integer> lotteryNumbers, int expected, String testMessage) {
        Lottery lottery = new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottery.countEqualNumbers(lotteryNumbers)).isEqualTo(expected);
    }

    static Stream<Arguments> lotteryNumbersProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(10, 11, 12, 13, 14, 15), 0, "0개 일치"),
                Arguments.of(Arrays.asList(1, 11, 12, 13, 14, 15), 1, "1개 일치"),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6, "6개 일치")
        );
    }

}
