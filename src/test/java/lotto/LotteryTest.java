package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LotteryTest {

    @Test
    @DisplayName("6개의 값이 일치하면 6개일치한 값이 1 증가한다.")
    void when_ThreeNumbersAreMatched() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lottery lottery = new Lottery(List.of(1, 2, 3, 4, 5, 6));

        Lotteries lotteries = new Lotteries(lottery, winningNumbers);
        List<Integer> integers = lotteries.calculateResult();

        Assertions.assertThat(integers.get(3)).isEqualTo(1);
    }


}