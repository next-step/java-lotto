package lotto;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    Lottery lottery = new Lottery();
    @Test
    void create45NumbersInBox() {
        assertThat(lottery.boxNumbers).hasSize(45);
    }

    @Test
    void numbersInBoxShouldBeUnique() {
        int actual = new HashSet<>(lottery.boxNumbers).size();
        int expected = lottery.boxNumbers.size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generate6Numbers() {
        assertThat(lottery.numbers).hasSize(6);
    }

    @Test
    void shuffledBoxShouldDifferWithOrigin() {
        List<Integer> origin = new ArrayList<>(lottery.boxNumbers);
        lottery.shuffleBox(LotteryBox.numbers);
        assertThat(lottery.boxNumbers).isNotEqualTo(origin);
    }

    @Test
    void shouldFindSixNumbers() {
        assertThat(lottery.findSixNumbers()).hasSize(6);
        assertThat(lottery.numbers).hasSize(6);
    }

    @Test
    void shouldSortAscend() {
        assertThat(lottery.sort(Arrays.asList(2,3,1))).isEqualTo(Arrays.asList(1,2,3));
    }
}
