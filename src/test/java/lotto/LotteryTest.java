package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    Lottery lottery = new Lottery(LotteryBox.numbers);
    @Test
    void create45NumbersInBox() {
        assertThat(lottery.box).hasSize(45);
    }

    @Test
    void generate6Numbers() {
        assertThat(lottery.numbers).hasSize(6);
    }

    @Test
    void shuffledBoxShouldDifferWithOrigin() {
        List<Integer> origin = new ArrayList<>(lottery.box);
        lottery.shuffleBox(LotteryBox.numbers);
        assertThat(lottery.box).isNotEqualTo(origin);
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
