package lottery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lottery.Lottery.getInstanceByInt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTest {

    @Test
    void generate_자동() {
        Lottery lottery = new Lottery();
        List<LotteryNumber> lotteryNumbers = lottery.getLotteryNumbers();

        assertThat(lotteryNumbers).hasSize(6);
        assertThat(lotteryNumbers).doesNotHaveDuplicates();
    }

    @Test
    void generate_수동() {
        assertThatThrownBy(() -> getInstanceByInt(Arrays.asList(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> getInstanceByInt(Arrays.asList(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "countEqualNumbers() - {2}")
    @MethodSource("lotteryNumbersProvider")
    void countEqualNumbers(Lottery lottery, int expected, String testMessage) {
        Lottery wonLottery = getInstanceByInt(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(wonLottery.countEqualNumbers(lottery)).isEqualTo(expected);
    }

    static Stream<Arguments> lotteryNumbersProvider() {
        return Stream.of(
                Arguments.of(getInstanceByInt(Arrays.asList(10, 11, 12, 13, 14, 15)), 0, "0개 일치"),
                Arguments.of(getInstanceByInt(Arrays.asList(1, 11, 12, 13, 14, 15)), 1, "1개 일치"),
                Arguments.of(getInstanceByInt(Arrays.asList(1, 2, 3, 4, 5, 6)), 6, "6개 일치")
        );
    }
}
