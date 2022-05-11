package lotto;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    Lottery lottery = new Lottery();

    @Test
    void create45NumbersInBox() {
        assertThat(lottery.lotteryBox.numbers).hasSize(45);
    }

    @Test
    void numbersInBoxShouldBeUnique() {
        int actual = new HashSet<>(lottery.lotteryBox.numbers).size();
        int expected = lottery.lotteryBox.numbers.size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generate6Numbers() {
        assertThat(lottery.numbers).hasSize(6);
    }

    @Test
    void shuffledBoxShouldDifferWithOrigin() {
        List<Integer> origin = new ArrayList(lottery.lotteryBox.numbers);
        LotteryBox.shuffleBox();
        assertThat(lottery.lotteryBox.numbers).isNotEqualTo(origin);
    }

    @Test
    void shouldFindSixNumbers() {
        assertThat(LotteryBox.findSixNumbers()).hasSize(6);
        assertThat(lottery.numbers).hasSize(6);
    }

    @Test
    void shouldSortAscend() {
        assertThat(LotteryBox.sort(Arrays.asList(2, 3, 1))).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void findWin() {
        Lottery lottery = new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottery answer = new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottery.findWin(answer)).isEqualTo(6);
    }
}
