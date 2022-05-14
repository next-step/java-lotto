package lotto;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    Lottery lottery = new Lottery();

    @Test
    void create45NumbersInBox() {
        assertThat(LotteryBox.numbers).hasSize(45);
    }

    @Test
    void numbersInBoxShouldBeUnique() {
        int actual = new HashSet<>(LotteryBox.numbers).size();
        int expected = LotteryBox.numbers.size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generate6Numbers() {
        assertThat(lottery.lotteryNumbers).hasSize(6);
    }

    @Test
    void shuffledBoxShouldDifferWithOrigin() {
        List<Integer> origin = new ArrayList(LotteryBox.numbers);
        LotteryBox.shuffleBox();
        assertThat(LotteryBox.numbers).isNotEqualTo(origin);
    }

    @Test
    void shouldFindSixNumbers() {
        assertThat(LotteryBox.findSixNumbers()).hasSize(6);
        assertThat(lottery.lotteryNumbers).hasSize(6);
    }

    @Test
    void shouldSortAscend() {
        assertThat(LotteryBox.sort(Lottery.toLotteryNumbers(Arrays.asList(2, 3, 1)))).isEqualTo(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3)));
    }

    @Test
    void findWin() {
        Lottery lottery = new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Winning winning = new Winning(new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),0);
        assertThat(lottery.findWin(winning)).isEqualTo(Reward.of(6, false));
    }
}
