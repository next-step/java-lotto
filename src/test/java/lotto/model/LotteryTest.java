package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LotteryTest {

    @Test
    void getNumbers() {
        List<Integer> numbers = Arrays.asList(1, 4, 5, 6, 7, 8);
        assertThat(new Lottery(numbers).getNumbers().size()).isEqualTo(6);
    }

    @Test
    void validate() {
        List<Integer> numbers = Arrays.asList(1, 4, 2);
        assertThatThrownBy(() -> new Lottery(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getWinningCount() {
        Lottery lottery = new Lottery(Arrays.asList(1, 4, 5, 6, 7, 20));
        assertThat(lottery.getWinningCount(Arrays.asList(1, 4, 5, 6, 7, 8))).isEqualTo(5);
    }
}